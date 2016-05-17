(ns clj-zemberek.stemming
  (:require [clj-zemberek.tokenization :as token]
            [clojure.string :as s])
  (:import [zemberek.morphology.parser MorphParse]
           [zemberek.morphology.parser.tr TurkishWordParserGenerator]
           [zemberek.morphology.ambiguity Z3MarkovModelDisambiguator]
           [zemberek.morphology.parser.tr TurkishSentenceParser]))

(def word-parser (TurkishWordParserGenerator/createWithDefaults))
(def morph-parser (TurkishWordParserGenerator/createWithDefaults))
(def disambiguator (Z3MarkovModelDisambiguator.))
(def sentence-parser (TurkishSentenceParser. morph-parser disambiguator))

(defn- entries
  [parse]
  (let [fp (.formatNoEmpty parse)
        parts (s/split
                (subs fp 2 (- (count fp) 2))
                #"\) \(")
        type_ (first (s/split (second parts) #"\W+"))]
    {:entry (first parts)
     :type type_}))


(defn- filtered
  [lst]
  (filter #(and
             (not= "UNK" %)
             (> (count %) 1)
             (not= "?" %))
          (into [] lst)))


(defn- filtered-entries
  [lst]
  (filter #(and
             (not= "UNK" (:entry %))
             (> (count (:entry %)) 1)
             (not= "?" (:entry %)))
          lst))


(defn stems
  [input]
  (let [words (token/simple-tokenization input)]
    (map
      (fn [word]
        (let [parses (.parse word-parser word)]
          (map (fn [parse]
                 {:key (entries parse)
                  :stems (filtered (.getStems parse))})
               parses)))
      words)))

(defn lemmas
  [input]
  (let [words (token/simple-tokenization input)]
    (map
      (fn [word]
        (let [parses (.parse word-parser word)]
          (map (fn [parse]
                 {:key (entries parse)
                  :lemmas (filtered (.getLemmas parse))})
               parses)))
      words)))

(defn lemma
  [input]
  (let [words (token/simple-tokenization input)
        lemmas (map #(.getLemma (first (.parse word-parser %))) words)]
    (filtered lemmas)))


(defn stem-and-ending
  [input]
  (let [words (token/simple-tokenization input)]
    (map
      (fn [word]
        (let [parses (.parse word-parser word)]
          (into [] (into #{} (map (fn [parse]
           (let [sae (.getStemAndEnding parse)]
             {:stem (.-stem sae)
              :ending (.-ending sae)}))
         parses)))))
      words)))


(defn parse-words
  [input]
  (let [words (token/simple-tokenization input)]
      (map
        (fn [word]
          (let [parses (.parse word-parser word)]
            (into [] (into #{} (map (fn [parse] (entries parse)) parses)))))
        words)))


(defn disambiguation
  [input]
  (let [sentence-parse (.parse sentence-parser input)]
    (.disambiguate sentence-parser sentence-parse)
    (map (fn [entry]
           (let [parse (.-parses entry)
                 entries (map #(entries %) parse)]
             {:entry (.-input entry)
              :best-match (first entries)
              :matches entries}))
         (iterator-seq (.iterator sentence-parse)))))
