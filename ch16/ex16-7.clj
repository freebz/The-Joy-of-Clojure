;; 예제 16.7 논리 변수들을 치환하여 두 시퀀스(seq) 혼합하기

(defn meld [term1 term2]
  (->> {}
       (satisfy term1 term2)
       (subst term1)))
