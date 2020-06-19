;; 예제 10.1 클로저의 ref를 사용한 3 ✕ 3체스 보드 표현

(def initial-board
  [[:- :k :- ]
   [:- :- :-]
   [:- :K :-]])

(defn board-map [f board]
  (vec (map #(vec (for [s %] (f s)))
            board)))
