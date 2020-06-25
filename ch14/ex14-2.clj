;; 예제 14.2 이벤트 구문 점검하기

(ns joy.event-sourcing)

(defn valid? [event]
  (boolean (:result event)))

(valid? {})
;;=> false

(valid? {:result 42})
;;=> true
