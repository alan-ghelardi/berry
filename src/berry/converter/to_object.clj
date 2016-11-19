(ns berry.converter.to-object
  (:require [berry.converter.increase-level :refer [increase-level]] 
            [berry.converter.to-member :refer [to-member]] 
            [berry.formatter.wrap :refer [wrap]] 
            [clojure.string :refer [join]]))

(declare members)

(defn to-object
  [value options]
  (str "{"
       (members value (increase-level options))
       (wrap "}" options)))

(defn- members
  [value options]
  (join ","
        (map #(to-member % options)
             value)))
