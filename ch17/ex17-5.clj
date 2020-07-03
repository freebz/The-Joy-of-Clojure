;; 예제 17.5 with-redefs로 스텁 생성하기

(ns joy.unit-testing
  (:require [joy.futures :as joy]))

(def stubbed-feed-children
  (constantly [{:content [{:tag :title
                           :content ["Stub"]}]}]))

(defn count-feed-entries [url]
  (count (joy/feed-children url)))

(count-feed-entries "http://blog.fogus.me/feed/")
;;=> 5

(with-redefs [joy/feed-children stubbed-feed-children]
  (count-feed-entries "dummy url"))
;; => 1
