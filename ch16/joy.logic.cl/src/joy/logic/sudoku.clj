(ns joy.logic.sudoku
  (:require [clojure.core.logic :as logic]
            [clojure.core.logic.fd :as fd]))

(defn rowify [board]
  (->> board
       (partition 9)
       (map vec)
       vec))


(def b1 '[3 - - - - 5 - 1 -
          - 7 - - - 6 - 3 -
          1 - - - 9 - - - -
          7 - 8 - - - - 9 -
          9 - - 4 - 8 - - 2
          - 6 - - - - 5 - 1
          - - - - 4 - - - 6
          - 4 - 7 - - - 2 -
          - 2 - 6 - - - - 3])


(rowify b1)

;;=> [[3 - - - - 5 - 1 -]
;     [- 7 - - - 6 - 3 -]
;     [1 - - - 9 - - - -]
;     [7 - 8 - - - - 9 -]
;     [9 - - 4 - 8 - - 2]
;     [- 6 - - - - 5 - 1]
;     [- - - - 4 - - - 6]
;     [- 4 - 7 - - - 2 -]
;     [- 2 - 6 - - - - 3]]


(defn colify [rows]
  (apply map vector rows))


(colify (rowify b1))
;;=> ([3 - 1 7 9 - - - -] [- 7 - - - 6 - 4 2] ... )


(defn subgrid [rows]
  (partition 9
    (for [row (range 0 9 3)
          col (range 0 9 3)
          x (range row (+ row 3))
          y (range col (+ col 3))]
      (get-in rows [x y]))))


(subgrid (rowify b1))

;;=> ((3 - - - 7 - 1 - -) (- - 5 - - 6 - 9 -) ... )


(def logic-board #(repeatedly 81 logic/lvar))


(defn init [[lv & lvs] [cell & cells]]
  (if lv
    (logic/fresh []
      (if (= '- cell)
        logic/succeed
        (logic/== lv cell))
      (init lvs cells))
    logic/succeed))


(defn solve-logically [board]
  (let [legal-nums (fd/interval 1 9)
        lvars (logic-board)
        rows (rowify lvars)
        cols (colify rows)
        grids (subgrid rows)]
    (logic/run 1 [q]
      (init lvars board)
      (logic/everyg #(fd/in % legal-nums) lvars)
      (logic/everyg fd/distinct rows)
      (logic/everyg fd/distinct cols)
      (logic/everyg fd/distinct grids)
      (logic/== q lvars))))


(defn prep [board]
        (map #(partition 3 %)
             (partition 9 board)))


(defn print-board [board]
  (let [row-sep (apply str (repeat 37 "-"))]
    (println row-sep)
    (dotimes [row (count board)]
      (print "| ")
      (doseq [subrow (nth board row)]
        (doseq [cell (butlast subrow)]
          (print (str cell "   ")))
        (print (str (last subrow) " | ")))
      (println)
      (when (zero? (mod (inc row) 3))
        (println row-sep)))))


(-> b1
    solve-logically
    first
    prep
    print-board)

;; -------------------------------------
;; | 3   8   6 | 2   7   5 | 4   1   9 | 
;; | 4   7   9 | 8   1   6 | 2   3   5 | 
;; | 1   5   2 | 3   9   4 | 8   6   7 | 
;; -------------------------------------
;; | 7   3   8 | 5   2   1 | 6   9   4 | 
;; | 9   1   5 | 4   6   8 | 3   7   2 | 
;; | 2   6   4 | 9   3   7 | 5   8   1 | 
;; -------------------------------------
;; | 8   9   3 | 1   4   2 | 7   5   6 | 
;; | 6   4   1 | 7   5   3 | 9   2   8 | 
;; | 5   2   7 | 6   8   9 | 1   4   3 | 
;; -------------------------------------
