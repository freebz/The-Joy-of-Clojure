;; 예제 12.4 요청 헤더를 출력하는 웹 핸들러

(def echo-handler
  (fn [_ exchange]
    (let [headers (.getRequestHeaders exchange)]
      (respond exchange (prn-str headers)))))


(update-proxy p {"handle" echo-handler})
