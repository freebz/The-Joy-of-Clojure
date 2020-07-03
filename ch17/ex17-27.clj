;; 예제 17.27 keys-apply 함수에 여러 개의 중단점 사용하기

(defmacro awhen [expr & body]
  (break)
  `(let [~'it ~expr]
     (if ~'it
       (do (break) ~@body))))

(awhen [1 2 3] (it 2))

debug=> it
; java.lang.RuntimeException: Unable to resolve symbol: it in this context

debug=> expr
;=> [1 2 3]

debug=> body
;=> ((it 2))

debug=> ::tl
debug=> it
;=> [1 2 3]

debug=> (it 1)
;=> 2

debug=> ::tl
;=> 3
