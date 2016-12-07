(ns berry.parsing.character)

(defn unicode-code-point
  [char]
  (if (number? char)
    char
  (.codePointAt char 0)))

(defn equal?
  [a-char other-char]
  (= (unicode-code-point a-char) (unicode-code-point other-char)))
