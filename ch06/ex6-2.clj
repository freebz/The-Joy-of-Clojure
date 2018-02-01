;; 예제 6.2 lazy-seq를 활용하여 스택 오버플로우가 발생하지 않도록 수정한 버전

(defn lz-rec-step [s]
  (lazy-seq
   (if (seq s)
     [(first s) (lz-rec-step (rest s))]
     [])))

(lz-rec-step [1 2 3 4])
;=> (1 (2 (3 (4 ()))))

(class (lz-rec-step [1 2 3 4]))
;=> clojure.lang.LazySeq

(dorun (lz-rec-step (range 200000)))

;=> nil
