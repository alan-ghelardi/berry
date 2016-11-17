(ns berry.formatter.extract-name)

(def ^:const name-pattern #"^:?([$_a-zA-Z][\w-]*)\??$")

(defn extract-name
  [name]
    (last
      (re-matches name-pattern
      (str name))))
