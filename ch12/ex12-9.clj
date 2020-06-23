;; 예제 12.9 로컬 파일 시스템을 탐색하고 목록을 만드는 웹 핸들러

(def fs-handler
  (fn [_ exchange]
    (let [uri (.getRequestURI exchange)
          file (uri->file "." uri)]
      (if (.isDirectory file)
        (do (.add (.getResponseHeaders exchange)
                  "Content-Type" "text/html")
            (respond html-around
                     exchange
                     (html-links (str uri) (listing file))))
        (respond exchange (details file))))))


(update-proxy p {"handle" fs-handler})
