;; 예제 11.9 with-promises를 사용한 병렬 테스트 실행기

(defrecord TestRun [run passed failed])

(defn pass [] true)
(defn fail [] false)

(defn run-tests [& all-tests]
  (with-promises
    [tests all-tests :as results]
    (into (TestRun. 0 0 0)
          (reduce #(merge-with + %1 %2) {}
            (for [r results]
              (if @r
                {:run 1 :passed 1}
                {:run 1 :failed 1}))))))

(run-tests pass fail fail fail pass)
;=> #joy.futures.TestRun{:run 5, :passed 2, :failed 3}
