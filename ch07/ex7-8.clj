;; 예제 7.8 A* 알고리즘 실행하기

(astar [0 0]
       900
       world)

;=> [{:cost 17,
;     :yxs [[0 0] [0 1] [0 2] [0 3] [0 4] [1 4] [2 4]
;           [2 3] [2 2] [2 1] [2 0] [3 0] [4 0] [4 1]
;           [4 2] [4 3] [4 4]]}
;     :steps 94]
