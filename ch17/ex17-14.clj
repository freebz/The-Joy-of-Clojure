;; 예제 17.14 추상 시스템 생성과 시스템 동작 프로토콜

(extend-type joy.patterns.abstract_factory.HiFiSim
  Sys
  (start! [this] (println "Started a hifi simulator."))
  (stop! [this] (println "Stopped a hifi simulator."))

  Sim
  (handle [this msg]
    (Thread/sleep 5000)
    (* (:weight msg) 3.1415926535897932384626M)))
