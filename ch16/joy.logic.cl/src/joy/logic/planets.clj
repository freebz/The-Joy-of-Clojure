(ns joy.logic.planets
  (:require [clojure.core.logic :as logic])
  (:require [clojure.core.logic.pldb :as pldb]))

(pldb/db-rel orbits orbital body)


(def facts
  (pldb/db
    [orbits :mercury :sun]
    [orbits :venus :sun]
    [orbits :earth :sun]
    [orbits :mars :sun]
    [orbits :jupiter :sun]
    [orbits :saturn :sun]
    [orbits :uranus :sun]
    [orbits :neptune :sun]))


(pldb/with-db facts
  (logic/run* [q]
    (logic/fresh [orbital body]
      (orbits orbital body)
      (logic/== q orbital))))

;;=> (:saturn :earth :uranus :neptune :mars :jupiter :venus :mercury)


(pldb/db-rel stars star)

(defn planeto [body]
  (logic/fresh [star]
    (stars star)
    (orbits body star)))

(def facts
  (pldb/db
    [orbits :mercury :sun]
    [orbits :venus :sun]
    [orbits :earth :sun]
    [orbits :mars :sun]
    [orbits :jupiter :sun]
    [orbits :saturn :sun]
    [orbits :uranus :sun]
    [orbits :neptune :sun]
    [stars :sun]))


(pldb/with-db facts
  (logic/run* [q]
    (planeto :earth)))

;;=> (_0)


(pldb/with-db facts
  (logic/run* [q]
    (planeto :earth)
    (logic/== q true)))

;;=> (true)


(pldb/with-db facts
  (logic/run* [q]
    (planeto :sun)
    (logic/== q true)))

;;=> ()


(pldb/with-db facts
  (logic/run* [q]
    (logic/fresh [orbital]
      (planeto orbital)
      (logic/== q orbital))))

;;=> (:saturn :earth :uranus :neptune :mars :jupiter :venus :mercury)


(def facts
  (pldb/db
    [orbits :mercury :sun]
    [orbits :venus :sun]
    [orbits :earth :sun]
    [orbits :mars :sun]
    [orbits :jupiter :sun]
    [orbits :saturn :sun]
    [orbits :uranus :sun]
    [orbits :neptune :sun]
    [stars :sun]
    [stars :alpha-centauri]
    [orbits :Bd :alpha-centauri]))

(pldb/with-db facts
  (logic/run* [q]
    (planeto :Bd)))
;;=> (_0)


(pldb/with-db facts
  (logic/run* [q]
    (logic/fresh [orbital]
      (planeto orbital)
      (logic/== q orbital))))
;;=> (:Bd :saturn :earth :uranus :neptune :mars :jupiter :venus :mercury)


(defn setelliteo [body]
  (logic/fresh [p]
    (orbits body p)
    (planeto p)))


(pldb/with-db facts
  (logic/run* [q]
    (setelliteo :sun)))

;;=> ()

(pldb/with-db facts
  (logic/run* [q]
    (setelliteo :earth)))

;;=> ()


(def facts
  (pldb/db
    [orbits :mercury :sun]
    [orbits :venus :sun]
    [orbits :earth :sun]
    [orbits :mars :sun]
    [orbits :jupiter :sun]
    [orbits :saturn :sun]
    [orbits :uranus :sun]
    [orbits :neptune :sun]
    [stars :sun]
    [stars :alpha-centauri]
    [orbits :Bd :alpha-centauri]
    [orbits :phobos :mars]
    [orbits :deimos :mars]
    [orbits :io :jupiter]
    [orbits :europa :jupiter]
    [orbits :ganymede :jupiter]
    [orbits :callisto :jupiter]))

(pldb/with-db facts
  (logic/run* [q]
    (setelliteo :io)))
;;=> (_0)


(pldb/with-db facts
  (logic/run* [q]
    (orbits :leda :jupiter)))
;;=> (_0)
