;; 예제 14.6 야구 선수들의 능력을 표현하는 데이터 모델

(ns joy.sim-test
  (:require [joy.event-sourcing :as es]
            [joy.generators :refer (rand-map)]
            [clojure.set :as sql]))


(def PLAYERS #{{:player "Nick", :ability 32/100}
               {:player "Matt", :ability 26/100}
               {:player "Ryan", :ability 19/100}})

(defn lookup [db name]
  (first (sql/select
          #(= name (:player %))
          db)))
