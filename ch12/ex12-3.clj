;; 예제 12.3 프록시를 사용한 기본적 웹 핸들러 정의

(defn default-handler [txt]
  (proxy [HttpHandler]
    []
    (handle [exchange]
      (respond exchange txt))))


(def server
  (new-server
   8123
   "/joy/hello"
   (default-handler "Hello Cleveland")))


(.stop server 0)


(def p (default-handler
        "There's no problem that can't be solved
with another level of indirection"))

(def server (new-server 8123 "/" p))


(update-proxy p
  {"handle" (fn [this exchange]
              (respond exchange (str "this is " this)))})
