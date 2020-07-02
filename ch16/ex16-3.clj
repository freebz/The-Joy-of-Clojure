;; 예제 16.3 논리 변수를 식별하는 함수

(defn lvar?
  "Determines if a value represents a logic variable"
  [x]
  (boolean
   (when (symbol? x)
     (re-matches #"^\?.*" (name x)))))
