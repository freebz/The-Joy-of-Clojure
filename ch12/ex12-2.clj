;; 예제 12.2 자바를 사용하는 가장 단순한 웹 서버

(defn new-server [port path handler]
  (doto

    (HttpServer/create (InetSocketAddress. port) 0)

    (.createContext path handler)
    (.setExecutor nil)
    (.start)))
