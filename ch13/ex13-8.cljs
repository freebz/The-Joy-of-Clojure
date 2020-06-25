;; 예제 13.8 analyze를 사용해서 클로저스크립트 파일에 대한 AST 생성하기

(ns joy.externs-for-cljs
  (:require [cljs.compiler :as comp]
            [cljs.analyzer :as ana]
            [clojure.walk :refer [prewalk]]
            [clojure.pprint :refer [pprint]]
            [clojure.java.io :as io])
  (:import (clojure.lang LineNumberingPushbackReader)))

(defn read-file
  "Read the contents of filename as a sequence of Clojure values."
  [filename]
  (let [eof (Object.)]
    (with-open [reader (LineNumberingPushbackReader.
                        (io/reader filename))]
      (doall
       (take-while #(not= % eof)
                   (repeatedly #(read reader false eof)))))))

(defn file-ast
  "Return the ClojureScript AST for the contents of filename. Tends to
  be large and to contain cycles -- be careful printing at the REPL."
  [filename]
  (binding [ana/*cljs-ns* 'cljs.user
            ana/*cljs-file* filename]
    (mapv #(ana/analyze (ana/empty-env) %)
          (read-file filename))))
