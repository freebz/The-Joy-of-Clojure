;; 예제 17.12 추상 시스템 생성과 시스템 동작 프로토콜

(defn build-system [name config]
  (let [sys (factory/construct name config)]
    (start! sys)
    sys))
