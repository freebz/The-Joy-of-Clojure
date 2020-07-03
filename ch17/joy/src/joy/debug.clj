(ns joy.debug)

(defn div [n d] (int (/ n d)))


(defn readr [prompt exit-code]
  (let [input (clojure.main/repl-read prompt exit-code)]
    (if (= input ::tl)
      exit-code
      input)))


(readr #(print "invisible=> ") ::exit)
[1 2 3]  ;; 사용자 입력

;=> [1 2 3]

(readr #(print "invisible=> ") ::exit)
::tl  ;; 사용자 입력

;=> :user/exit


(defmacro local-context []
  (let [symbols (keys &env)]
    (zipmap (map (fn [sym] `(quote ~sym))
                 symbols)
            symbols)))


(local-context)
;=> {}

(let [a 1, b 2, c 3]
  (let [b 200]
    (local-context)))
;=> {a 1, b 200, c 3}


(require '[joy.macros :refer (contextual-eval)])

(defmacro break []
  `(clojure.main/repl
    :prompt #(print "debug=> ")
    :read readr
    :eval (partial contextual-eval (local-context))))


(defn div [n d] (break) (int (/ n d)))
(div 10 0)


debug=> n
;=> 10

debug=> d
;=> 0

debug=> (local-context)
;=> {n 10, d 0}

debug=> ::tl
; .ArithmeticException: Divide by zero 
