;; 예제 10.7 간단한 SafeArray 프로토콜

(ns joy.locks
  (:refer-clojure :exclude [agent aset count seq])
  (:require [clojure.core :as clj])
  (:use [joy.mutation :only (dothreads!)])
  (:import (joy.locks SafeArray)))

(defprotocol SafeArray
  (aset [this i f])
  (aget [this i])
  (count [this])
  (seq [this]))

(defn make-dumb-array [t sz]
  (let [a (make-array t sz)]
    (reify
      SafeArray
      (count [_]  (clj/count a))
      (seq [_]    (clj/seq a))
      (aget [_ i] (clj/aget a i))
      (aset [this i f]
        (clj/aset a
                  i
                  (f (aget this i)))))))
