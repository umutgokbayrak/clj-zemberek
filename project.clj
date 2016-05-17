(defproject org.clojars.umutgokbayrak/clj-zemberek "0.4.0"
  :description "Clojure wrapper for Zemberek (NLP for Turkish language)"
  :url "https://github.com/umutgokbayrak/clj-zemberek"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [zemberek-nlp/core "0.9.2"]
                 [zemberek-nlp/morphology "0.9.2"]
                 [zemberek-nlp/tokenization "0.9.2"]]
  :repositories {"zemberek" "https://raw.github.com/ahmetaa/maven-repo/master"})
