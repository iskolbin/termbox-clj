(ns termbox.core
  (:gen-class))

(defn -main
  []
  (try
    (do
      (Termbox/init)
      (Termbox/setInputMode Termbox/INPUT_MOUSE)
      (Termbox/clear)
      (Termbox/setCells 1 1 "This is just test of termbox library working through JNI in Clojure" (+ Termbox/GREEN Termbox/UNDERLINE) Termbox/DEFAULT)
      (Termbox/setCells 1 2 "Unicode is working" Termbox/BLUE Termbox/DEFAULT)
      (Termbox/setCells 1 3 "Нажми любую кнопку для выхода, дружище" (+ Termbox/RED Termbox/BOLD) Termbox/DEFAULT)
      (Termbox/setCells 1 4 "To exit press any keyboard key or mouse" Termbox/CYAN Termbox/RED)
      (Termbox/present)
      (Termbox/poll))
    (finally
      (Termbox/shutdown))))
