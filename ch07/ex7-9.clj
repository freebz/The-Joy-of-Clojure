;; 예제 7.9 관목림 세계

(astar [0 0]
       900
       [[1    1    1    2    1]
        [1    1    1  999    1]
        [1    1    1  999    1]
        [1    1    1  999    1]
        [1    1    1    1    1]])

;=> [{:cost 9,
;     :yxs [[0 0] [0 1] [0 2]
;           [1 2]
;           [2 2]
;           [3 2]
;           [4 2] [4 3] [4 4]]}
;     :steps 134]
