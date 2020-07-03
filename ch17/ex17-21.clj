;; 예제 17.21 적절하지 않은 트리 노드를 예외로 처리하기

(defn ^:dynamic handle-weird-animal
  [{[name] :content}]
  (throw (Exception. (str name " must be 'dealt with'"))))
