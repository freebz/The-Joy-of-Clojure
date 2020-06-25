;; 예제 14.8 데이터베이스에 야구 결과 이벤트 반영하기

(defn update-stats [db event]
  (let [player  (lookup db (:player event))
        less-db (sql/difference db #{player})]
    (conj less-db
          (merge player (es/effect player event)))))
