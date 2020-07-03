;; 예제 17.3 처리기 목록에서 구문 처리기 조회하기

(defn apply-syntax [[op & args]]
  (apply (get *clause-map* op) args))
