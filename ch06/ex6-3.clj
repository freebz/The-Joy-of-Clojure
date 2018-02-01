;; 예제 6.3 선언적 솔루션 작성을 위한 무한 시퀀스 활용

(defn triangle [n]
  (/ (* n (+ n 1)) 2))



(def tri-nums (map triangle (iterate inc 1)))

(take 10 tri-nums)
;=> (1 3 6 10 15 21 28 36 45 55)

(take 10 (filter even? tri-nums))
;=> (6 10 28 36 66 78 120 136 190 210)

(nth tri-nums 99)
;=> 5050

(double (reduce + (take 1000 (map / tri-nums))))
;=> 1.998001998001998

(take 2 (drop-while #(< % 10000) tri-nums))
;=> (10011 10153)
