;; 예제 17.25 중단점 매크로 구현하기

(require '[joy.macros :refer (contextual-eval)])

(defmacro break []
  `(clojure.main/repl
    :prompt #(print "debug=> ")
    :read readr
    :eval (partial contextual-eval (local-context))))
