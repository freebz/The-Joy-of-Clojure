;; 예제 1.3 연산자 우선순위에 따라 평가하도록 변경되는 함수

(defn infix3 [a op1 b op2 c]
  (if (< (get order op1) (get order op2))
    (r->lfix a op1 b op2 c)
    (l->rfix a op1 b op2 c)))
