;; 예제 17.15 고성능, 저성능 모델의 답변을 모두 계산

(def excellent (promise))

(defn simulate [answer fast slow opts]
  (future (deliver answer (handle slow opts)))

  (handle fast opts))
