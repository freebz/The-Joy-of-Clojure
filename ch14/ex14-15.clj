;; 예제 14.15 시뮬레이션 드라이버

(defn simulate [total players]
  (let [events  (apply interleave
                         (for [player players]
                           (rand-events total player)))
        results (feed-all (ref players) events)]
    (apply await (map #(agent-for-player (:player %)) players))
    @results))
