;; 예제 1.8 로컬 범위의 캡슐화

(defn lookup3 [board pos]
  (let [[file rank] (map int pos)
        [fc rc]      (map int [\a \0])
        f (- file fc)
        r (* 8 (- 8 (- rank rc)))
        index (+ f r)]
    (board index)))

;; (lookup3 (initial-board) "a1")
;;=> \R
