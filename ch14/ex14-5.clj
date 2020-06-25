;; 예제 14.5 이벤트 소싱과 다수의 이벤트를 반영하는 함수

(def effect-all #(reduce apply-effect %1 %2))
