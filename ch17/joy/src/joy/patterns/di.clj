(ns joy.patterns.di
  (:require [joy.patterns.abstract-factory :as factory]))

(def lofi {:type :sim, :descr "Lowfi sim", :fidelity :low})

(def hifi {:type :sim, :descr "Hifi sim", :fidelity :high, :threads 2})


(factory/construct :lofi lofi)

;;=> #joy.patterns.abstract_factory.LowFiSim{:name :lofi}



(defprotocol Sys
  (start! [sys])
  (stop!  [sys]))

(defprotocol Sim
  (handle [sim msg]))


(defn build-system [name config]
  (let [sys (factory/construct name config)]
    (start! sys)
    sys))


(extend-type joy.patterns.abstract_factory.LowFiSim
  Sys
  (start! [this]
    (println "Started a lofi simulator."))
  (stop! [this]
    (println "Stopped a lofi simulator."))

  Sim
  (handle [this msg]
    (* (:weight msg) 3.14)))


(start! (factory/construct :lofi lofi))
;; Started a lofi simulator.


(build-system :sim1 lofi)
;; Started a lofi simulator.
;;=> #joy.patterns.abstract_factory.LowFiSim{:name :sim1}


(handle (build-system :sim1 lofi) {:weight 42})
;; Started a lofi simulator.
;;=> 131.88


(extend-type joy.patterns.abstract_factory.HiFiSim
  Sys
  (start! [this] (println "Started a hifi simulator."))
  (stop! [this] (println "Stopped a hifi simulator."))

  Sim
  (handle [this msg]
    (Thread/sleep 5000)
    (* (:weight msg) 3.1415926535897932384626M)))


(build-system :sim2 hifi)
;; Started a hifi simulator.
;;=> #joy.patterns.abstract_factory.HiFiSim{:name :sim2, :threads 2}

(handle (build-system :sim2 hifi) {:weight 42})
;; Started a hifi simulator.
;; 5초 경과 후...
;;=> 131.9468914507713160154292M


(def excellent (promise))

(defn simulate [answer fast slow opts]
  (future (deliver answer (handle slow opts)))

  (handle fast opts))


(simulate excellent
          (build-system :sim1 lofi)
          (build-system :sim2 hifi)
          {:weight 42})

;;=> 131.88


(realized? excellent)
;;=> false


;; 수초 경과 후

(realized? excellent)
;;=> true

@excellent
;;=> 131.9468914507713160154292M
