;; 예제 17.11 시스템 동작 시뮬레이션을 기술하는 프로토콜

(defprotocol Sys
  (start! [sys])
  (stop!  [sys]))

(defprotocol Sim
  (handle [sim msg]))
