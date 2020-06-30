;; 예제 15.6 로컬을 강제 변환하여 사용하는 팩토리얼

(defn factorial-b [original-x]
  (loop [x (long original-x), acc 1]
    (if (>= 1 x)
      acc
      (recur (dec x) (* x acc)))))

(time (dotimes [_ 1e5] (factorial-b 20)))
; "Elapsed time: 44.687297 msecs"
