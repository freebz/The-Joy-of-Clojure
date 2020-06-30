;; 예제 15.12 축약 함수를 리턴하도록 range 함수 재구현하기

(defn reducible-range [start end step]
  (fn [reducing-fn init]
    (loop [result init, i start]
      (if (empty-range? i end step)
        result
        (recur (reducing-fn result i)
               (+ i step))))))
