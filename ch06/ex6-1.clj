;; 예제 6.1 if 표현식 단축 평가

(defn if-chain [x y z]
  (if x
    (if y
      (if z
        (do
          (println "Made it!")
          :all-truthy)))))

(if-chain () 42 true)
; Made it!
;=> :all-truthy

(if-chain true true false)
;=> nil
