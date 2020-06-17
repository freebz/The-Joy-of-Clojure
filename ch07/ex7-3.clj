;; 예제 7.3 남아있는 직선 경로 비용을 추정하는 함수

(defn estimate-cost [step-cost-est size y x]
  (* step-cost-est
     (- (+ size size) y x 2)))

(estimate-cost 900 5 0 0)
;=> 7200

(estimate-cost 900 5 4 4)
;=> 0
