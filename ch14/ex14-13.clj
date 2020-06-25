;; 예제 14.13 데이터 저장소와 선수 이벤트 저장소에 이벤트 공급하기

(defn feed [db event]
  (let [a (agent-for-player (:player event))]
    (send a
          (fn [state]
            (commit-event db event)
            (conj state event)))))
