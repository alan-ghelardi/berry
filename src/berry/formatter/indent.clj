(ns berry.formatter.indent)

(defn- indent-with
  [character width]
  (apply str (repeat width character)))

(def tab (partial indent-with "\t"))

(def space (partial indent-with " "))

(defn indent
  [text { prettify? :prettify?
         make-indented :indent-style
         indent-size :indent-size
         level :level}]
  (if (not prettify?)
    text  
    (let [width (* indent-size level)] 
      (str (make-indented width) text))))
