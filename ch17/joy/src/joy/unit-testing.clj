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


(with-redefs [joy/feed-children stubbed-feed-children]
  (joy/occurences joy/title "Stub" "a" "b" "c"))

;;=> 3


(require '[clojure.test :refer (deftest testing is)])

(deftest feed-tests
  (with-redefs [joy/feed-children stubbed-feed-children]
    (testing "Child Counting"
      (is (= 1000 (count-feed-entries "Dummy URL"))))
    (testing "Occurrence Counting"
      (is (= 0 (joy/count-text-task
                joy/title
                "ZOMG"
                "Dummy URL"))))))


(clojure.test/run-tests 'joy.unit-testing)
;; Testing joy.unit-testing

;; FAIL in (feed-tests) (form-init6068443557114648948.clj:93)
;; Child Counting
;; expected: (= 1000 (count-feed-entries "Dummy URL"))
;;   actual: (not (= 1000 1))

;; Ran 1 tests containing 2 assertions.
;; 1 failures, 0 errors.
;; {:test 1, :pass 1, :fail 1, :error 0, :type :summary}
