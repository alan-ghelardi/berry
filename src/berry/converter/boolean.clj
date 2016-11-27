(ns berry.converter.boolean)

(defn boolean?
  [candidate]
  (instance? Boolean candidate))
