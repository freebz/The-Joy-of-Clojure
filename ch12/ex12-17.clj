;; 예제 12.17 프로토콜을 사용한 ISliceable 확장

(defprotocol Sliceable
  (slice [this s e])
  (sliceCount [this]))

(extend ISliceable
  Sliceable
  {:slice (fn [this s e] (.slice this s e))
   :sliceCount (fn [this] (.sliceCount this))})

(sliceCount dumb)
;=> 42

(slice dumb 0 0)
;=> [:empty]
