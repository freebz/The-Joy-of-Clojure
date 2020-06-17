;; 예제 7.4 현재까지의 경로 비용을 계산하는 함수

(defn path-cost [node-cost cheapest-nbr]
  (+ node-cost
     (or (:cost cheapest-nbr) 0)))

(path-cost 900 {:cost 1})
;=> 901
