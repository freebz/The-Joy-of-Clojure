;; 예제 17.16 시스템에 대한 목(mock) 만들기

(ns joy.patterns.mock
  (:require [joy.patterns.abstract-factory :as factory]
            [joy.patterns.di :as di]))

(defrecord MockSim [name])

(def starts (atom 0))
