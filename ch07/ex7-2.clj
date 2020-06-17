;; 예제 7.2 상호 재귀 함수를 사용한 유한 상태 기계 구현

(defn elevator [commands]
  (letfn
      [(ff-open [[_ & r]]
         "엘리베이터가 1층에서 문이 열려있으면 문을 닫거나 종료할 수 있다."
         #(case _
            :close (ff-closed r)
            :done  true
            false))
       (ff-closed [[_ & r]]
         "엘리베이터가 1층에서 문이 닫혀있으면 문을 열거나 올라갈 수 있다."
         #(case _
            :open (ff-open r)
            :up   (sf-closed r)
            false))
       (sf-closed [[_ & r]]
         "엘리베이터가 2층에서 문이 닫혀있으면 문을 열거나 내려갈 수 있다."
         #(case _
            :down (ff-closed r)
            :open (sf-open r)
            false))
       (sf-open [[_ & r]]
         "엘리베이터가 2층에서 문이 열려있으면 문을 닫거나 종료할 수 있다."
         #(case _
            :close (sf-closed r)
            :done  true
            false))]
    (trampoline ff-open commands)))
