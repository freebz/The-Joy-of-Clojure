;; 예제 14.12 선수명에 해당하는 에이전트 검색 또는 생성

(def agent-for-player
  (memoize
   (fn [player-name]
     (let [a (agent [])]
       (set-error-handler! a #(println "ERROR: " %1 %2))
       (set-error-mode! a :fail)
       a))))
