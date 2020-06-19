;; 예제 10.8 locking 매크로를 사용한 SafeArray 구현

(defn make-safe-array [t sz]
  (let [a (make-array t sz)]
    (reify
      SafeArray
      (count [_] (clj/count a))
      (seq [_] (clj/seq a))
      (aget [_ i]
        (locking a
          (clj/aget a i)))
      (aset [this i f]
        (locking a
          (clj/aset a
                    i
                    (f (aget this i))))))))
