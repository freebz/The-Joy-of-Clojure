;; 예제 15.18 CollReduce 프로토콜을 통해 reducible 범위 구현하기

(defn reduce-range [reducing-fn init, start end step]
  (loop [result init, i start]
    (if (empty-range? i end step)
      result
      (recur (reducing-fn result i)
             (+ i step)))))

(require '[clojure.core.protocols :as protos])
(defn core-reducible-range [start end step]
  (reify protos/CollReduce
    (coll-reduce [this reducing-fn init]
      (reduce-range reducing-fn init, start end step))
    (coll-reduce [this reducing-fn]
      (if (empty-range? start end step)
        (reducing-fn)
        (reduce-range reducing-fn start, (+ start step) end step)))))
