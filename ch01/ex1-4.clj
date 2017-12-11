;; 예제 1.4 다형적인 Concatenatable 프로토콜

(defprotocol Concatenatable
  (cat [this other]))
