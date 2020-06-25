;; 예제 14.14 데이터 저장소와 선수 이

(defn feed-all [db events]
  (doseq [event events]
    (feed db event))
  db)
