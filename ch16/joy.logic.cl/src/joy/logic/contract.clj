(ns joy.logic.contract
  (:require [clojure.core.logic :as logic]))

(logic/run* [q]
  (logic/fresh [x y]
    (logic/== q [x y])))

;;=> ([_0 _1])


(logic/run* [q]
  (logic/fresh [x y]
    (logic/== [:pizza "Java"] [x y])
    (logic/== q [x y])))

;;=> ([:pizza "Java"])


(logic/run* [q]
  (logic/fresh [x y]
    (logic/== q [x y])
    (logic/!= y "Java")))

;;=> (([_0 _1] :- (!= (_1 "Java"))))


(logic/run* [q]
  (logic/fresh [x y]
    (logic/== [:pizza "Java"] [x y])
    (logic/== q [x y])
    (logic/!= y "Java")))

;;=> ()


(logic/run* [q]
  (logic/fresh [x y]
    (logic/== ["Clojure" "Scala"] [x y])
    (logic/== q [x y])
    (logic/!= y "java")))

;;=> (["Clojure" "Scala"])


(logic/run* [q]
  (logic/fresh [n]
    (logic/== q n)))

;;=> (_0)


(logic/run* [q]
  (logic/fresh [n]
    (logic/!= 0 n)
    (logic/== q n)))

;;=> ((_0 :- (!= (_0 0))))


(require '[clojure.core.logic.fd :as fd])


;; 무한히 동작하니 감안하여 실행할 것
(logic/run* [q]
  (logic/fresh [n]
    (fd/in n (fd/interval 1 Integer/MAX_VALUE))
    (logic/== q n)))

;;=> (1 2 3 ... many more numbers follow)


(logic/run* [q]
  (logic/fresh [n]
    (fd/in n (fd/domain 0 1))
    (logic/== q n)))

;;=> (0 1)


(logic/run* [q]
  (let [coin (fd/domain 0 1)]
    (logic/fresh [heads tails]
      (fd/in heads 0 coin)
      (fd/in tails 1 coin)
      (logic/== q [heads tails]))))

;;=> ([0 0] [1 0] [0 1] [1 1])
