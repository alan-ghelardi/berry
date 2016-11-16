(ns berry.converters.to-member
  (:require [berry.formatting :refer [indent]]))

(declare colon transform-name)

(defn to-member
  [[name value] options to-json]
  (let [{prettify? :prettify?} options
        name (transform-name name options)
        value (to-json value options to-json)]
    (str name
         (colon prettify?)
         value)))

(defn- colon
  [prettify?]
  (if prettify?
    " : "
    ":"))

(defn- transform-name
  [name options]
  (let [{prettify? :prettify?} options]
    (if prettify?
      (indent name options)
      name)))
