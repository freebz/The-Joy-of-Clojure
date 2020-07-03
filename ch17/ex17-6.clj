;; 예제 17.6 부분적 규격으로서의 clojure.test

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
