;; 예제 8.1 최상위 레벨 매크로 contract

(declare collect-bodies)

(defmacro contract [name & forms]
  (list* `fn name (collect-bodies forms)))
