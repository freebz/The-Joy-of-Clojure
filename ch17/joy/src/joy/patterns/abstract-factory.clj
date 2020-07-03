(ns joy.patterns.abstract-factory)

(def config
  '{:systems {:pump {:type :feeder, :descr "Feeder system"}
              :sim1 {:type :sim,    :fidelity :low}
              :sim2 {:type :sim,    :fidelity :high, :threads 2}}})


(defn describe-system [name cfg]
  [(:type cfg) (:fidelity cfg)])


(describe-system :pump {:type :feeder, :descr "Feeder system"})

;;=> [:feeder nil]




(defmulti construct describe-system)

(defmethod construct :default [name cfg]
  {:name name
   :type (:type cfg)})

(defn construct-subsystem [sys-map]
  (for [[name cfg] sys-map]
    (construct name cfg)))


(defmethod construct [:feeder nil]
  [_ cfg]
  (:descr cfg))

(construct-subsystem (:systems config))
;;=> ("Feeder system"
;;    {:name :sim1, :type :sim}
;;    {:name :sim2, :type :sim})


(defrecord LowFiSim [name])
(defrecord HiFiSim  [name threads])


(defmethod construct [:sim :low]
  [name cfg]
  (->LowFiSim name))

(defmethod construct [:sim :high]
  [name cfg]
  (->HiFiSim name (:threads cfg)))


(construct-subsystem (:systems config))

;;=> ("Feeder system"
;;    #joy.patterns.abstract_factory.LowFiSim{:name :sim1}
;;    #joy.patterns.abstract_factory.HiFiSim{:name :sim2, :threads 2})
