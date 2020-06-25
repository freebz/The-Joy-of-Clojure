;; 예제 14.16 측정의 구성 단위들에 대한 계산 확인

(in-ns 'joy.unit)

(defn relative-units [context unit]
  (if-let [spec (get context unit)]
    (if (vector? spec)
      (convert context spec)
      spec)
    (throw (RuntimeException. (str "Undefined unit " unit)))))
