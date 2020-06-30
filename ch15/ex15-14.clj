;; 예제 15.14 Reducible과 함께 사용되는 filtering의 핵심 부분

(defn filtering [filter-pred]
  (fn [f1]
    (fn [result input]
      (if (filter-pred input)
        (f1 result input)

        result))))
