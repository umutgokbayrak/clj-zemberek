(ns clj-zemberek.stemming-test
  (:require [clojure.test :refer :all]
            [clj-zemberek.stemming :refer :all]))

(def sentence "İzmir'in Bayındır İlçesi’nde av tüfeğiyle vurularak öldürülmüş bulunan 33 yaşındaki Şahin Özbay’ın katil zanlısı olduğu belirlenen M.O., araçları arızalı gibi davranan sivil giyimli jandarma tarafından yakalandı. Şanlıurfa’da yaşayan Özbay’ın yakınlarının ise katil zanlısının yakalanıp öldürülmesi için 100 bin TL ödül biçtiği iddia edildi.")

(deftest stems-test
;;   (println "----------")
;;   (println "Stems Test")
;;   (println "----------")
;;   (println (stems sentence) "count:" (count (stems sentence)))
  (testing "FIXME, I fail."
    (is (not (empty? (stems sentence))))))


(deftest lemmas-test
;;   (println "-----------")
;;   (println "Lemmas Test")
;;   (println "-------0---")
;;   (println (lemmas sentence) "count:" (count (lemmas sentence)))
  (testing "FIXME, I fail."
    (is (not (empty? (lemmas sentence))))))


(deftest lemma-test
;;   (println "----------")
;;   (println "Lemma Test")
;;   (println "----------")
;;   (println (lemma sentence))
  (testing "FIXME, I fail."
    (is (not (empty? (lemma sentence))))))


(deftest stem-and-ending-test
;;   (println "--------------------")
;;   (println "Stem And Ending Test")
;;   (println "--------------------")
;;   (println (stem-and-ending sentence))
  (testing "FIXME, I fail."
    (is (not (empty? (stem-and-ending sentence))))))


(deftest parse-words-test
;;   (println "----------------")
;;   (println "Parse Words Test")
;;   (println "----------------")
;;   (println (parse-words sentence))
  (testing "FIXME, I fail."
    (is (not (empty? (parse-words sentence))))))


(deftest disambiguation-test
;;   (println "-------------------")
;;   (println "Disambiguation Test")
;;   (println "-------------------")
;;   (println (disambiguation sentence))
  (testing "FIXME, I fail."
    (is (not (empty? (disambiguation sentence))))))
