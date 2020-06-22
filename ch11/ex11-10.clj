;; 예제 11.10 with-promises를 사용한 병렬 테스트 실행기

(defn cps->fn [f k]
  (fn [& args]
    (let [p (promise)]
      (apply f (fn [x] (deliver p (k x))) args)
      @p)))

(def count-items (cps->fn feed-items count))

(count-items "http://blog.fogus.me/feed/")
;=> 5
