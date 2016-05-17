(ns clj-zemberek.tokenization
  (:import [com.google.common.base Joiner]
           [org.antlr.v4.runtime Token]
           [zemberek.tokenizer ZemberekLexer]
           [zemberek.tokenizer SimpleSentenceBoundaryDetector]))

(def lexer (ZemberekLexer.))
(def detector (SimpleSentenceBoundaryDetector.))

(defn antlr-tokenization
  "Low level tokenization iterator using Ant-lr Lexer."
  [input]
  (map (fn [token]
         {:text (.getText token)
          :type (.getType token)})
       (iterator-seq (.getTokenIterator lexer input))))


(defn simple-tokenization
  "Simple tokenization returns a list of token strings."
  [input]
  (into [] (.tokenStrings lexer input)))


(defn sentences
  "Sentence Boundary Detection"
  [input]
  (into [] (.getSentences detector input)))
