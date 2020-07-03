;; 예제 17.10 멀티메서드를 사용하여 구성(concrete) 팩토리 정의하기

(defmethod construct [:sim :low]
  [name cfg]
  (->LowFiSim name))

(defmethod construct [:sim :high]
  [name cfg]
  (->HiFiSim name (:threads cfg)))
