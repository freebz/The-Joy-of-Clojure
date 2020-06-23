;; 예제 12.7 파일 크기를 문자열로 표현하는 함수

(defn details [file]
  (str (.getName file) " is "
       (.length file)  " bytes."))

(details (io/file "./README.md"))

;;=> "README.md is 330 bytes."
