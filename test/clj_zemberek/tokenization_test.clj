(ns clj-zemberek.tokenization-test
  (:require [clojure.test :refer :all]
            [clj-zemberek.tokenization :refer :all]))

(def sentence "İzmir'in Bayındır İlçesi’nde av tüfeğiyle vurularak öldürülmüş bulunan 33 yaşındaki Şahin Özbay’ın katil zanlısı olduğu belirlenen M.O., araçları arızalı gibi davranan sivil giyimli jandarma tarafından yakalandı. Şanlıurfa’da yaşayan Özbay’ın yakınlarının ise katil zanlısının yakalanıp öldürülmesi için 100 bin TL ödül biçtiği iddia edildi.")

(deftest antlr-tokenization-test
;;   (println (antlr-tokenization sentence))
  (testing "FIXME, I fail."
    (is (not (empty? (antlr-tokenization sentence))))))


(deftest simple-tokenization-test
;;   (println (simple-tokenization sentence))
  (testing "FIXME, I fail."
    (is (not (empty? (simple-tokenization sentence))))))


(deftest simple-sentences-test
;;   (println (sentences sentence))
  (testing "FIXME, I fail."
    (is (not (empty? (sentences sentence))))
    (is (= (count (sentences sentence)) 2))))

