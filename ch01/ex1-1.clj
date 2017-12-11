;; 예제 1.1 우좌 방향으로 계산식을 평가하는 함수

(defn r->lfix
  ([a op b]                 (op a b))
  ([a op1 b op2 c]          (op1 a (op2 b c)))
  ([a op1 b op2 c op3 d]    (op1 a (op2 b (op3 c d)))))
