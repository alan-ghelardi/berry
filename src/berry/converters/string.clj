(ns berry.converters.string)

(defn to-string
  [value options]
  (str "\"" value "\""))
