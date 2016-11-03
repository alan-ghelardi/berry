(ns berry
  (:require [berry.converters.json-element :refer [to-json-element]]))

(defn stringify
  ([value]
    (stringify value {}))
  ([value options]
  (to-json-element value options)))
