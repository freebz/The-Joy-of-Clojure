;; 예제 15.9 기본형 double 인자를 사용한 팩토리얼

(defn factorial-e [^double original-x]
  (loop [x original-x, acc 1.0]
    (if (>= 1.0 x)
      acc
      (recur (dec x) (* x acc)))))

(factorial-e 10.0)
;=> 3628800.0

(factorial-e 20.0)
;=> 2.43290200817664E18

(factorial-e 30.0)
;=> 2.652528598121911E32

(factorial-e 171.0)
;=> Infinity

(time (dotimes [_ 1e5] (factorial-e 20.0)))
; "Elapsed time: 15.678149 msecs"
