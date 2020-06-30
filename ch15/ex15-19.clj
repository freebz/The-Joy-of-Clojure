;; 예제 15.19 변환기를 코어 foldable로 전환하기

(defn core-f-map [mapping-fn core-reducible]
  (r/folder core-reducible (mapping mapping-fn)))

(defn core-f-filter [filter-pred core-reducible]
  (r/folder core-reducible (filtering filter-pred)))
