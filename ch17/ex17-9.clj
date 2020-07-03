;; 예제 17.9. 멀티 메소드를 사용한 추상 팩토리 구현의 기초

(defmulti construct describe-system)

(defmethod construct :default [name cfg]
  {:name name
   :type (:type cfg)})

(defn construct-subsystem [sys-map]
  (for [[name cfg] sys-map]
    (construct name cfg)))
