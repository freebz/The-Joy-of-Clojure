;; 예제 12.13 더 복잡한 GUI 예제

(.display gui
  (let [g1 (txt 10 "Charlemagne")
        g2 (txt 10 "Pipin")
        r  (txt 3 "10")
        d  (txt 3 "5")]
    (splitter
     (stack
      (stack
       (shelf (label "Player 1") g1)
       (shelf (label "Player 2") g2)
       (shelf (label "Rounds ") r
              (label "Delay  ") d))
      (stack
       (grid 21 11 #(label "-"))
       (button "Go!" #(alert (str (.getText g1) " vs. "
                                  (.getText g2) " for "
                                  (.getText r) " rounds, every "
                                  (.getText d) " seconds. "))))))))
