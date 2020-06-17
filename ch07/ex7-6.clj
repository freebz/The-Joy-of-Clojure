;; 예제 7.6 기준 함수를 기반으로 가장 작은 값을 찾아주는 함수

(defn min-by [f coll]
  (when (seq coll)
    (reduce (fn [min other]
              (if (> (f min) (f other))
                other
                min))
            coll)))

(min-by :cost [{:cost 100} {:cost 36} {:cost 9}])

;;=> {:cost 9}
