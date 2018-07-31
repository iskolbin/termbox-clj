(ns termbox.core
  (:gen-class))

(defn -main
  []
  (Termbox/init)
  (Termbox/setInputMode Termbox/INPUT_MOUSE)
  (Termbox/clear)
  (Termbox/setCells 1 1 "This is just test of termbox library working through JNI in Clojure" (+ Termbox/GREEN Termbox/UNDERLINE) Termbox/DEFAULT 0)
  (Termbox/setCells 1 2 "Unicode is working" Termbox/BLUE Termbox/DEFAULT 0)
  (Termbox/setCells 1 3 "Нажми любую кнопку для выхода, дружище" (+ Termbox/RED Termbox/BOLD) Termbox/DEFAULT 0)
  (Termbox/setCells 1 4 "To exit press any keyboard key or mouse" Termbox/CYAN Termbox/RED 0)
  (Termbox/present)
  (Termbox/poll)
  (Termbox/shutdown))
