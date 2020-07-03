;; 예제 17.23 일반적인 디버깅 콘솔 리더

(defn readr [prompt exit-code]
  (let [input (clojure.main/repl-read prompt exit-code)]
    (if (= input ::tl)
      exit-code
      input)))
