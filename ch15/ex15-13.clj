;; 예제 15.13 Reducible과 함께 사용되는 mapping의 핵심 부분

(defn mapping [map-fn]

  (fn map-transformer [f1]
    (fn [result input]
      (f1 result (map-fn input)))))
