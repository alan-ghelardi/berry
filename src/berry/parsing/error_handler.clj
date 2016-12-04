(ns berry.parsing.error-handler)

(defn- raise-error
  [message {line :line
            column :column
            offset :offset}]
  (throw (java.text.ParseException. 
         (str message " at line " line ", column " column ".") offset)))

(defn unexpected-token
  [char context]
  (raise-error (str "Unexpected token " char) context))
