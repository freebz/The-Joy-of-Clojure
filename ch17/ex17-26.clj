;; 예제 17.26 keys-apply 함수에 여러 개의 중단점 사용하기

(defn keys-apply [f ks m]
  (break)
  (let [only (select-keys m ks)]
    (break)
    (zipmap (keys only) (map f (vals only)))))

(keys-apply inc [:a :b] {:a 1, :b 2, :c 3})

debug=> only
                                        ; java.lang.RuntimeException: Unable to resolve symbol: only in this context

debug=> ks
;=> [:a :b]

debug=> m
;=> {:a 1, :b 2, :c 3}

debug=> ::tl
debug=> only
;=> {:a 1, :b 2}

debug=> ::tl
;=> {:a 2, :b 3}
