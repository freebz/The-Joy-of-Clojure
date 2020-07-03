;; 예제 17.2 SQL과 비슷한 연산자들을 중위 연산자 위치로 재배치하기

(ns joy.sql
  (:use [clojure.string :as str :only []]))

(defn shuffle-expr [expr]
  (if (coll? expr)
    (if (= (first expr) `unquote)
      "?"
      (let [[op & args] expr]
        (str "("
          (str/join (str " " op " ")
                    (map shuffle-expr args)) ")")))
    expr))
