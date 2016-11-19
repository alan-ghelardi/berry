(ns berry.converter.to-member
  (:require [berry.formatter.indent :refer [indent]]
            [berry.formatter.wrap :refer [wrap]]))

(declare transform-name transform-value)

(defn to-member
  [[name value] {prettify? :prettify? :as options}]
  (let [name (transform-name name options)
        value (transform-value value options)
        colon (if prettify? " : " ":")]
    (wrap
      (str name colon value)
      options)))

(defn- transform-name
  [name {transform :naming-style
         :as options}]
  (indent 
    (transform name)
    options))

(defn- transform-value
  [value {to-json :to-json
          :as options}]
  (to-json value))
