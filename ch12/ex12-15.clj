;; 예제 12.15 조각낼 수 있는 객체를 정의하는 인터페이스

(ns joy.slice)

(definterface ISliceable
  (slice [^long s ^long e])
  (^int sliceCount []))
