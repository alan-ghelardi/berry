(ns berry.converter.increase-level)

(defn increase-level
  [options]
  (let [level (:level options)]
    (into options
          {:level (inc level)})))
