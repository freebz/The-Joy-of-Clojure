;; 예제 8.3 contract 함수와 제약 조건 함수 구성

(def doubler-contract
  (contract doubler
    [x]
    (require
      (pos? x))
    (ensure
      (= (* 2 x) %))))

(def times2 (partial doubler-contract #(* 2 %)))

(times2 9)
;=> 18

(def times3 (partial doubler-contract #(* 3 %)))

(times3 9)
; java.lang.AssertionError Assert failed: (= (* 2 x) %)
