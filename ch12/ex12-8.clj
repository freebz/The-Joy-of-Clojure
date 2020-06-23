;; 예제 12.8 상대적 경로의 URI를 파일로 변환하는 함수

(defn uri->file [root uri]
  (->> uri
       str
       URLDecoder/decode
       (str root)
       io/file))

(uri->file "." (URI. "/project.clj"))
;;=> #object[java.io.File 0x2c30a1 "./project.clj"]

(details (uri->file "." (URI. "/project.clj")))
;;=> "project.clj is 289 bytes."
