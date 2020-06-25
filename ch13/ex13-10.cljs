;; 예제 13.10 클로저에서 동작할 수 있도록 수정한 notes 함수

(defn notes [tone-pairs]
  "Returns a sequence of note maps at moderate tempo for the given
  sequence of tone-pairs."
  (let [bpm 360
        bps (/ bpm 60)]
    (->> tone-pairs
         (map pair-to-note)
         consecutive-notes
         (map #(update-in % [:delay] (comp double /) bps))
         (map #(update-in % [:duration] (comp double /) bps)))))
