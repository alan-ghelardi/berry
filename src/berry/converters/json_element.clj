(ns berry.converters.json-element
  (:require [berry.converters.array :refer [to-array]]
  [berry.converters.object :refer [to-object]]
  [berry.converters.primitive :refer [to-primitive]]
  [berry.converters.string :refer [to-string]]))

(def converters {
                 java.lang.Boolean to-primitive
                 java.lang.Double to-primitive
                 java.lang.Long to-primitive
                 java.lang.String to-string
                 })

(defn to-json-element
  [value options]
  (def convert (get converters (type value)))
  (convert value options))
