(ns berry.converter.to-json
  (:require [berry.converter.boolean :refer [boolean?]] 
            [berry.converter.to-object :refer [to-object]] 
            [berry.converter.to-primitives :refer [to-boolean to-null to-number to-string]]))

(declare converter-for that-accepts)

(def converters [
                 {:accept? boolean? :converter to-boolean}
                 {:accept? nil? :converter to-null}
                 {:accept? number? :converter to-number}
                 {:accept? map? :converter to-object}
                 {:accept? string? :converter to-string}
                 ])

(defn to-json
  [value options]
  (let [convert (converter-for value)]
    (convert value options)))

(defn- converter-for
  [value]
  (:converter
    (first 
      (filter #(that-accepts value %) converters))))

(defn- that-accepts
  [value {accept? :accept?}]
  (accept? value))
