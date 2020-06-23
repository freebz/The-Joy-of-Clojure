;; 예제 12.18 String이 Sliceable 프로토콜을 따르도록 확장하기

(defn calc-slice-count [thing]
  "다음 공식을 사용하여 가능한 조각 개수를 계산:
       (n + r - 1)!
      --------------
        r!(n - 1)!
   n은 (count thing), r은 2"
  (let [! #(reduce * (take % (iterate inc 1)))
        n (count thing)]
    (/ (! (- (+ n 2) 1))
       (* (! 2) (! (- n 1))))))

(extend-type String
  Sliceable
  (slice [this s e] (.substring this s (inc e)))
  (sliceCount [this] (calc-slice-count this)))

(slice "abc" 0 1)
;=> "ab"
(sliceCount "abc")
;=> 6
