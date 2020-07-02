;; 예제 16.8 공전하는 행성 질의하기

(pldb/with-db facts
  (logic/run* [q]
    (logic/fresh [orbital body]
      (orbits orbital body)
      (logic/== q orbital))))

;;=> (:saturn :earth :uranus :neptune :mars :jupiter :venus :mercury)
