;; 예제 17.24 &env를 사용한 로컬 컨텍스트 맵 생성

(defmacro local-context []
  (let [symbols (keys &env)]
    (zipmap (map (fn [sym] `(quote ~sym))
                 symbols)
            symbols)))
