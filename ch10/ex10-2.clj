;; 예제 10.2 ref 예제 구성하기

(defn reset-board!
  "보드 상태를 리셋한다. 일반적으로 이러한 방식의 함수가 권장되지는 않지만,
  지면의 제한을 고려해야 했다."
  []
  (def board (board-map ref initial-board))
  (def to-move (ref [[:K [2 1]] [:k [0 1]]]))
  (def num-moves (ref 0)))

(def king-moves
  (partial neighbors
           [[-1 -1] [-1 0] [-1 1] [0 -1] [0 1] [1 -1] [1 0] [1 1]] 3))

(defn good-move?
  [to enemy-sq]
  (when (not= to enemy-sq)
    to))

(defn choose-move
  "적절한 이동을 랜덤하게 선택"
  [[[mover mpos] [_ enemy-pos]]]
  [mover (some #(good-move? % enemy-pos)
               (shuffle (king-moves mpos)))])
