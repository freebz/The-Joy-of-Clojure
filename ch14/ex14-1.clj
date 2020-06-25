;; 예제 14.1 거리 단위를 읽는 함수

(in-ns 'joy.unit)

(def distance-reader
  (partial convert
           {:m  1
            :km 1000,
            :cm 1/100,
            :mm [1/10 :cm]}))
