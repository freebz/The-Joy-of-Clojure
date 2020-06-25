;; 예제 14.3 상태를 변경하는 이벤트 소싱 함수

(defn effect [{:keys [ab h] :or {ab 0, h 0}}
              event]
  (let [ab (inc ab)
        h  (if (= :hit (:result event))
             (inc h)
             h)
        avg (double (/ h ab))]
    {:ab ab :h h :avg avg}))
