(ns laxam-clojure-tutorial-part1.core
  (:gen-class))

(defn ask-guess
  "Ask player to make a guess"
  []
  (print "Make your guess: ")
  (flush)
  (read-string (read-line)))

(defn play
  "Perform single step of the game"
  [secret tries]
  (let [guess (ask-guess)
        wrong (fn [msg] (println msg) (play secret (+ 1 tries)))]
    (cond
      (> guess secret) (wrong "Your guess is too large")
      (< guess secret) (wrong "Your guess is too small")
      (= guess secret) (println "Congratulations! You won in" tries "tries!")
      :else (do (println "I don't understand you")
                (play secret tries)))))

(defn -main
  [& args]
  (println "Hi. I have a secret number between 0 and 100.")
  (play (+ 1 (rand-int 100)) 0))
