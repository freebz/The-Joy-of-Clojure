;; 예제 1.2 좌우 방향으로 계산식을 평가하는 함수

(defn l->rfix
  ([a op b]                 (op a b))
  ([a op1 b op2 c]          (op2 c (op1 a b)))
  ([a op1 b op2 c op3 d]    (op3 d (op2 c (op1 a b)))))
