;; 예제 17.8 타율 계산에 defformula 사용하기

(def h (ref 25))
(def ab (ref 100))

(defformula avg
  [at-bats ab, hits h]
  (float (/ @hits @at-bats)))
