;; 예제 16.6 데이터 구조를 살펴보면서 논리 변수들을 바인딩 값으로 치환하기

(require '[clojure.walk :as walk])

(defn subst [term binds]
  (walk/prewalk
    (fn [expr]
      (if (lvar? expr)
        (or (binds expr) expr)
        expr))
    term))
