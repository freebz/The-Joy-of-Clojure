;; 예제 13.2 IFn을 LinkedMap으로 확장하기

(.set m 43 :odd)

(m 43)
; org.mozilla.javascript.EcmaError:
;     TypeError: Cannot find function call in object [object Object]

(extend-type goog.structs.LinkedMap
  cljs.core/IFn
  (-invoke
    ([m k] (.get m k nil))
    ([m k not-found] (.get m k not-found))))


(m 43)
;=> :odd
