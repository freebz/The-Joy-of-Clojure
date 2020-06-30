;; 예제 15.17 변환기를 코어 reducible로 바꾸기

(require '[clojure.core.reducers :as r])
(defn core-r-map [mapping-fn core-reducible]
  (r/reducer core-reducible (mapping mapping-fn)))

(defn core-r-filter [filter-pred core-reducible]
  (r/reducer core-reducible (filtering filter-pred)))
