;; 예제 11.1 XML 피드를 XML zipper로 변환하기

(ns joy.futures
  (:require (clojure [xml :as xml]))
  (:require (clojure [zip :as zip]))
  (:import  (java.util.regex Pattern)))

(defn feed->zipper [uri-str]
  (->> (xml/parse uri-str)
       zip/xml-zip))
