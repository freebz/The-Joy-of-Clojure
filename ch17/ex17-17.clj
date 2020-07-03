;; 예제 17.17 목 시스템을 기존의 프로토콜로 확장하기

(extend-type MockSim
  di/Sys
  (start! [this]
    (if (= 1 (swap! starts inc))
      (println "Started a mock simulator.")
      (throw (RuntimeException. "Called start! more than once."))))
  (stop! [this] (println "Stopped a mock simulator."))

  di/Sim
  (handle [_ _] 42))
