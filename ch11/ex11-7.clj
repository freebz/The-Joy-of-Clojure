;; 예제 11.7 피드 제목에서 문자열 출현 빈도를 병렬적으로 계수하기

(defn occurrences [extractor tag & feeds]
  (as-futures [feed feeds]
    (count-text-task extractor tag feed)
    :as results
    =>
    (reduce + (map deref results))))
