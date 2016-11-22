(ns berry.converter.to-primitives
  (:require [berry.formatter.enclose-in-double-quotes :refer [enclose-in-double-quotes]]))

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
  (enclose-in-double-quotes value))
