;; 예제 13.3 print-ast 함수 정의

(require '[clojure.walk :refer [prewalk]]
         '[clojure.pprint :refer [pprint]])

(defn print-ast [ast]
  (pprint
   (prewalk
    (fn [x]
      (if (map? x)
        (select-
         keys x [:children :name :from :op])
        x))
    ast)))
