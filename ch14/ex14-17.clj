;; 예제 14.17 defunits-of 매크로

(defmacro defunits-of [name base-unit & conversions]
  (let [magnitude (gensym)
        unit (gensym)
        units-map (into `{~base-unit 1}
                        (map vec (partition 2 conversions)))]
    `(defmacro ~(symbol (str "unit-of-" name))
       [~magnitude ~unit]
       `(* ~~magnitude
           ~(case ~unit
                  ~@(mapcat
                     (fn [[u# & r#]]
                       `[~u# ~(relative-units units-map u#)])
                     units-map))))))
