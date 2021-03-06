;; 예제 17.1 클로저의 관계 대수 함수를 사용한 select * 예제

(def artists
  #{{:artist "Burial"  :genre-id 1}
    {:artist "Magma"   :genre-id 2}
    {:artist "Can"     :genre-id 3}
    {:artist "Faust"   :genre-id 3}
    {:artist "Iknoika" :genre-id 3}
    {:artist "Grouper"}})

(def genres
  #{{:genre-id 1 :genre-name "Dubstep"}
    {:genre-id 2 :genre-name "Zeuhl"}
    {:genre-id 3 :genre-name "Prog"}
    {:genre-id 4 :genre-name "Drone"}})



(require '[clojure.set :as ra])

(def ALL identity)

(ra/select ALL genres)

;;=> #{{:genre-id 4, :genre-name "Drone"}
;      {:genre-id 3, :genre-name "Prog"}
;      {:genre-id 2, :genre-name "Zeuhl"}
;      {:genre-id 1, :genre-name "Dubstep"}}


(ra/select (fn [m] (#{1 3} (:genre-id m))) genres)

;;=> #{{:genre-id 3, :genre-name "Prog"}
;      {:genre-id 1, :genre-name "Dubstep"}}


(defn ids [& ids]
  (fn [m] ((set ids) (:genre-id m))))


(ra/select (ids 1 3) genres)

;;=> #{{:genre-id 3, :genre-name "Prog"}
;      {:genre-id 1, :genre-name "Dubstep"}}


(take 2 (ra/select ALL (ra/join artists genres)))

;;=> ({:genre-id 2, :genre-name "Zeuhl", :artist "Magma"}
;     {:genre-id 3, :genre-name "Prog", :artist "Can"})
