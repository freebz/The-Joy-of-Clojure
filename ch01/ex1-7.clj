;; 예제 1.7 블록 범위 캡슐화 사용

(letfn [(index [file rank]
          (let [f (- (int file) (int \a))
                r (* 8 (- 8 (- (int rank) (int \0))))]
            (+ f r)))]
  (defn lookup2 [board pos]
    (let [[file rank] pos]
      (board (index file rank)))))

(lookup2 (initial-board) "a1")
;;=> \R
