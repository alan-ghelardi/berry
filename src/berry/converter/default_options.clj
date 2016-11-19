(ns berry.converter.default-options
  (:require [berry.converter.to-json :refer [to-json]] 
            [berry.formatter.camelize :refer [camelize]] 
            [berry.formatter.indent :refer [tab]]))

(def default-options {
                      :indent-size 2
                      :indent-style tab
                      :level 0
                      :prettify? true
                      :naming-style camelize
                      :to-json to-json
                      })
