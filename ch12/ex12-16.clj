;; 예제 12.16 더미 ISliceable 구현

(def dumb
  (reify ISliceable
    (slice [_ s e] [:empty])
    (sliceCount [_] 42)))

(.slice dumb 1 2)
;=> [:empty]

(.sliceCount dumb)
;=> 42
