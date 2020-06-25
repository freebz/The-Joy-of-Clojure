;; 예제 14.10 선수 능력에 따른 랜덤 야구 이벤트 생성하기

(defn rand-event [{ability :ability}]
  (let [able (numerator ability)
        max (denominator ability)]
    (rand-map 1
              #(-> :result)
              #(if (< (rand-int max) able)
                 :hit
                 :out))))
