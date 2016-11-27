(ns berry.converter.increase-level)

(defn increase-level
  [{level :level :as options}]
  (into options
        {:level (inc level)}))
