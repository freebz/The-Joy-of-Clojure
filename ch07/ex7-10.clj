;; 예제 7.10 식인종 세계

(astar [0 0]
       900
       [[1    1    1    2    1]
        [1    1    1  999    1]
        [1    1    1  999    1]
        [1    1    1  999    1]
        [1    1    1  666    1]])

;=> [{:cost 10,
;     :yxs [[0 0] [0 1] [0 2] [0 3] [0 4]
;           [1 4]
;           [2 4]
;           [3 4]
;           [4 4]]}
;     :steps 132]