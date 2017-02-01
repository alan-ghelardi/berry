(ns berry.lexical-analysis.token
  (:require [clojure.string :refer [join]]))

(defrecord Token
  [type value start end])

(defrecord Location
  [line column])

(defn- create-token
  [ type value {
                start-line :start-line
                start-column :start-column
                end-line :current-line
                end-column :current-column}]
  (map->Token {:type type
               :value (join value)
               :start (Location. start-line start-column)
               :end (Location. end-line end-column)}))

(def literal (partial create-token "literal"))

(def number (partial create-token "number"))

(def structural (partial create-token "structural"))

(def string (partial create-token "string"))
