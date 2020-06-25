;; 예제 13.9 클로저에서 동작할 수 있도록 수정한 consecutive-notes 함수

(defn consecutive-notes
  "Take a sequences of note maps that have no :delay, and return them
  with correct :delay's so that they will play in the order given."
  [notes]
  (reductions (fn [{:keys [delay duration]} note]
                (assoc note
                  :delay (+ delay duration)))
              {:delay 0 :duration 0}
              notes))
