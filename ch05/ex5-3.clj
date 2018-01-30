;; 예제 5.3 pos 함수 최종 버전

(defn index [coll]
  (cond
    (map? coll) (seq coll)
    (set? coll) (map vector coll coll)
    :else (map vector (iterate inc 0) coll)))

(defn pos [e coll]
  (for [[i v] (index coll) :when (= e v)] i))


(defn pos [pred coll]
  (for [[i v] (index coll) :when (pred v)] i))
