;; 예제 15.7 기본형 long 인자를 사용하는 팩토리얼 함수

(defn factorial-c [^long original-x]
  (loop [x original-x acc 1]
    (if (>= 1 x)
      acc
      (recur (dec x) (* x acc)))))

(time (dotimes [_ 1e5] (factorial-c 20)))
; "Elapsed time: 43.797143 msecs"
