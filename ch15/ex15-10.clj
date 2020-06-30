;; 예제 15.10 자동 승급을 사용하는 팩토리얼

(defn factorial-f [^long original-x]
  (loop [x original-x, acc 1]
    (if (>= 1 x)
      acc
      (recur (dec x) (*' x acc)))))

(factorial-f 20)
;=> 2432902008176640000

(factorial-f 30)
;=> 265252859812191058636308480000000N

(factorial-f 171)
;=> 124101... this goes on a while ...000N

(time (dotimes [_ 1e5] (factorial-f 20)))
; "Elapsed time: 101.7621 msecs"
