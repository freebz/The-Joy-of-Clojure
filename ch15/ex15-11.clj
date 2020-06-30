;; 예제 15.11 lazy-seq를 활용한 클로저 range 함수 재구현

(defn empty-range? [start end step]
  (or (and (pos? step) (>= start end))
      (and (neg? step) (<= start end))))

(defn lazy-range [i end step]
  (lazy-seq
   (if (empty-range? i end step)
     nil
     (cons i
           (lazy-range (+ i step)
                       end
                       step)))))
