;; 예제 16.9 논리 변수로 채운 스도쿠 보드를 재귀적으로 초기화하기

(defn init [[lv & lvs] [cell & cells]]
  (if lv
    (logic/fresh []
      (if (= '- cell)
        logic/succeed
        (logic/== lv cell))
      (init lvs cells))
    logic/succeed))
