(ns berry.lexical-analysis.scan-structural
  (:require [berry.lexical-analysis.token :as token]))

(defn scan-structural
  [source context]
  (token/structural (first source) context))
