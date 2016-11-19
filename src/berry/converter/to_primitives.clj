(ns berry.converter.to-primitives)

(defn to-boolean
  [value options]
  (str value))

(defn to-null
  [value options]
  "null")

(defn to-number
  [value options]
  (str value))

(defn to-string
  [value options]
  (str "\"" value "\""))
