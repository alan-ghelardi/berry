(ns berry.formatter.indent)

(defn- indent-with
[character width]
  (apply str (repeat width character)))

(def tab (partial indent-with "\t"))

(def space (partial indent-with " "))

(defn indent
[text {apply-indentation :indent-style
  indent-size :indent-size
  level :level}]
(let [width (* indent-size level)] 
    (str (apply-indentation width) text)))
