;; 예제 15.8 오버플로우 확인을 하지 않는 팩토리얼

(set! *unchecked-math* true)

(defn factorial-d [^long original-x]
  (loop [x original-x, acc 1]
    (if (>= 1 x)
      acc
      (recur (dec x) (* x acc)))))

(set! *unchecked-math* false)
