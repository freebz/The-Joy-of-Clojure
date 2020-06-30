;; 예제 15.15 Reducible과 함께 사용되는 mapcatting의 핵심 부분

(defn mapcatting [map-fn]
  (fn [f1]
    (fn [result input]
      (let [reducible (map-fn input)]
        (reducible f1 result)))))
