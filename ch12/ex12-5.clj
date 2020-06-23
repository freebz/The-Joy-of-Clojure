;; 예제 12.5 OutputStream을 head와 body 태그로 감싸는 around 필터

(defn html-around [o]
  (proxy [FilterOutputStream]
    [o]
    (write [raw-bytes]
      (proxy-super write
        (.getBytes (str "<html><body>"
                        (String. raw-bytes)
                        "</body></html>"))))))


(defn listing [file]
  (-> file .list sort))


(listing (io/file "."))
;=> ("gitignore" "README.md" "project.clj" "src" "target" "test")

(listing (io/file "./README.md"))
;=> ()
