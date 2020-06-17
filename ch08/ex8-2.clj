;; 예제 8.2 contract의 보조 함수 build-contract

(defn build-contract [c]
  (let [args (first c)]
    (list
     (into '[f] args)
     (apply merge
            (for [con (rest c)]
              (cond (= (first con) 'require)
                      (assoc {} :pre (vec (rest con)))
                    (= (first con) 'ensure)
                      (assoc {} :post (vec (rest con)))
                    :else (throw (Exception.
                                  (str "Unknown tag "
                                       (first con)))))))
     (list* 'f args))))
