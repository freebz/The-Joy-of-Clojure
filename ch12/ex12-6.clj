;; 예제 12.6 파일 목록을 HTML 문자열로 생성하는 간단한 함수

(defn html-links [root filenames]
  (string/join
   (for [file filenames]
     (str "<a href='"
          (str root
               (if (= "/" root)
                 ""
                 File/separator)
               file)
          "'>"
          file "</a><br>"))))


(html-links "." (listing (io/file ".")))
;;=> "<a href='./.gitignore'>.gitignore</a><br>
;;       <a href='./README.md'>README.md</a><br>
;;       <a href='./project.clj'>project.clj</a><br>
;;       <a href='./src'>src</a><br>
;;       <a href='./target'>target</a><br>
;;       <a href='./test'>test</a><br>"
