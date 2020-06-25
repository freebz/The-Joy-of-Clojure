;; 예제 13.1 ICounted를 LinkedMap으로 확장하기

(ns joy.linked_map
  (:require [goog.structs.LinkedMap]))

(extend-type goog.structs.LinkedMap
  cljs.core.ICounted
  (-count [m] (.getCount m)))

(def m (goog.structs.LinkedMap.))

(count m)
;=> 0

(.set m :foo :bar)
(.set m :baz :qux)

(count m)
;=> 2
