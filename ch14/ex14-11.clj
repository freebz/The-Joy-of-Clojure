;; 예제 14.11 다수의 랜덤 야구 이벤트 생성하기

(defn rand-events [total player]
  (take total
        (repeatedly #(assoc (rand-event player)
                            :player
                            (:player player)))))
