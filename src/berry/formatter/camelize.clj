(ns berry.formatter.camelize
  (:require [berry.formatter.extract-name :refer :all]
            [clojure.string :as string]))

(defn camelize
  [some-identifier]
  (let [name (extract-name some-identifier)
        parts (string/split name #"-+|_+")]
    (apply
      str
      (first parts)
      (map string/capitalize (rest parts)))))
