;; 예제 12.10 gen-class 다양한 사용 방법을 보여주는 DynaFrame 클래스 네임스페이스 블록

(ns joy.gui.DynaFrame
  (:gen-class
   :name         joy.gui.DynaFrame
   :extends      javax.swing.JFrame
   :implements   [clojure.lang.IMeta]
   :prefix       "df-"
   :state        state
   :init         init
   :constructors {[String] [String]
                 []  [String]}
   :methods      [[display [java.awt.Container] void]
                  ^{:static true} [version [] String]])
  (:import (javax.swing JFrame JPanel JComponent)
           (java.awt BorderLayout Container)))
