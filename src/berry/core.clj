(ns berry.core
  (:require [berry.converter.default-options :as converter] 
    [berry.converter.to-json :refer [to-json]]
            [berry.formatter.camelize :refer [camelize]]
            [berry.formatter.indent :as formatter]))

(def camel-case camelize)

(def tab formatter/tab)
 
(def space formatter/space)

(defn stringify
  ([data]
  (stringify data converter/default-options))
  ([data options]
    (let [options (into converter/default-options options)]
      (to-json data options))))
