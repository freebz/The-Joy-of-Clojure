;; 예제 12.14 java.util.List와 시퀀스(seq)간의 대응

(.get '[a b c ] 1)
;=> b

(.get (repeat :a) 138)
;=> a

(.containsAll '[a b c] '[b c])
;=> true

(.add '[a b c] 'd)
; UnsupportedOperationException
