;; 예제 15.1 캐싱을 위한 프로토콜

(defprotocol CacheProtocol
  (lookup  [cache e])
  (has?    [cache e])
  (hit     [cache e])
  (miss    [cache e ret]))
