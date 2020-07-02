(ns joy.logic.cl
  (:require [clojure.core.logic :as logic]))


(logic/run* [answer]
  (logic/== answer 5))
;;=> (5)


(logic/run* [val1 val2]
  (logic/== {:a val1, :b 2}
            {:a 1, :b val2}))

;;=> ([1 2])


(logic/run* [x y]
  (logic/== x y))

;;=> ([_0 _0])


(logic/run* [q]
  (logic/== q 1)
  (logic/== q 2))

;;=> ()


(logic/run* [george]
  (logic/conde
   [(logic/== george :born)]
   [(logic/== george :unborn)]))

;;=> (:born :unborn)
