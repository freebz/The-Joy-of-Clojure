;; 예제 8.4 여러 개의 인자를 받는 함수를 위한 contract

(def doubler-contract
  (contract doubler
    [x]
    (require
      (pos? x))
    (ensure
      (= (* 2 x) %))
    [x y]
    (require
      (pos? x)
      (pos? y))
    (ensure
      (= (* 2 (+ x y)) %))))

((partial doubler-contract #(* 2 (+ %1 %2))) 2 3)
;=> 10

((partial doubler-contract #(+ %1 %1 %2 %2)) 2 3)
;=> 10

((partial doubler-contract #(* 3 (+ %1 %2))) 2 3)
; AssertionError Assert failed: (= (* 2 (+ x y)) %)
