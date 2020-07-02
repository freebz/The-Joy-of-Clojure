;; 예제 16.5 시퀀스(seq) 동일성 충족 함수

(defn satisfy
  [l r knowledge]
  (let [L (get knowledge l l)
        R (get knowledge r r)]
    (cond
      (not knowledge)        nil
      (= L R)          knowledge
      (lvar? L)        (assoc knowledge L R)
      (lvar? R)        (assoc knowledge R L)
      (every? seq? [L R])
        (satisfy (rest L)
                 (rest R)
                 (satisfy (first L)
                          (first R)
                          knowledge))
      :default nil)))
