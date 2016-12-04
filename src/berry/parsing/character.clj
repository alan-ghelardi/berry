(ns berry.parsing.character)

(defn unicode-code-point
  [char]
  (.codePointAt char 0))
