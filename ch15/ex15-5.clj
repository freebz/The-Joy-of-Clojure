;; 예제 15.5 타입 선언을 사용하지 않는 꼬리 재귀 팩토리얼

(defn factorial-a [original-x]
  (loop [x original-x acc 1]
    (if (>= 1 x)
      acc
      (recur (dec x) (* x acc)))))
