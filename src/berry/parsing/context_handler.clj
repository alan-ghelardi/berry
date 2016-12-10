(ns berry.parsing.context-handler)

(def begin {
            :start-line 1
            :start-column 1
            :current-line 1
            :current-column 1
            :offset 0})

(defn ++
  [{current-column :current-column
    offset :offset
    :as context}]
  (merge context {
                  :current-column (inc current-column)
                  :offset (inc offset)}))

(defn --
  [{current-column :current-column
    offset :offset
    :as context}]
  (merge context {
                  :current-column (dec current-column)
                  :offset (dec offset)}))
