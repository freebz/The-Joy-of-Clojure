;; 예제 17.18 목 시스템을 위한 생성자

(defmethod factory/construct [:mock nil]
  [nom _]
  (MockSim. nom))
