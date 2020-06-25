;; 예제 14.9 데이터 저장소에 결과 이벤트를을 트랜잭션 방식으로 반영하기

(defn commit-event [db event]
  (dosync (alter db update-stats event)))

(commit-event (ref PLAYERS) {:player "Nick", :result :hit})

;;=> #{ ... }
