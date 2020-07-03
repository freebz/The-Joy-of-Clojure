;; 예제 17.13 추상 시스템 생성과 시스템 동작 프로토콜

(extend-type joy.patterns.abstract_factory.LowFiSim
  Sys
  (start! [this]
    (println "Started a lofi simulator."))
  (stop! [this]
    (println "Stopped a lofi simulator."))

  Sim
  (handle [this msg]
    (* (:weight msg) 3.14)))
