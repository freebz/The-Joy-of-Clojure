;; 예제 17.19 환경 설정으로 시스템 구성하기

(ns joy.patterns.app
  (:require [joy.patterns.di :as di]))

(def config {:type :mock, :lib 'joy.patterns.mock})
