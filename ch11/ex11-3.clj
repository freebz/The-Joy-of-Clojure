;; 예제 11.3 일반화된 피드 구조에서 제목 조회하기

(defn title [entry]
  (some->> entry
           :content
           (some #(when (= :title (:tag %)) %))
           :content
           first))
