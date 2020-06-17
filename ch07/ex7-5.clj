;; 예제 7.5 전체 비용를 추정하는 함수

(defn total-cost [newcost step-cost-est size y x]
  (+ newcost
     (estimate-cost step-cost-est size y x)))

(total-cost 0 900 5 0 0)
;=> 7200

(total-cost 1000 900 5 3 4)
;=> 1900

(total-cost (path-cost 900 {:cost 1}) 900 5 3 4)
;=> 1801
