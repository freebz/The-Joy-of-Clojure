;; 예제 14.4 이벤트가 유효한 경우에만 반영하는 함수

(defn apply-effect [state event]
  (if (valid? event)
    (effect state event)
    state))
