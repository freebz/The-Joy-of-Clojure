;; 예제 11.2 RSS와 Atom 피드 엔트리 일반화하기

(defn normalize [feed]
  (if (= :feed (:tag (first feed)))
    feed
    (zip/down feed)))

(defn feed-children [uri-str]
  (->> uri-str
       feed->zipper
       normalize
       zip/children
       (filter (comp #{:item :sntry} :tag))))
