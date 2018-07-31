(defproject termbox "0.1.0-SNAPSHOT"
  :description "Clojure JNI binding to Termbox library"
  :license {:name "MIT"}
  :dependencies [[org.clojure/clojure "1.9.0"]]
  :java-source-paths ["src-java"]
  :aot [termbox.core]
  :jar-name "termbox.jar"
  :auto-clean false
  :uberjar-name "termbox-standalone.jar"
  :main termbox.core)
