(ns berry.lexical-analysis.context-handler)

(def begin {
            :start-line 1
            :start-column 1
            :current-line 1
            :current-column 1
            :offset 0})

(defn- apply-to 
  [transform {current-column :current-column
              offset :offset
              :as context}]
  (assoc context 
         :current-column (transform current-column)
         :offset (transform offset)))

(def ++ (partial apply-to inc))

(def -- (partial apply-to dec))
