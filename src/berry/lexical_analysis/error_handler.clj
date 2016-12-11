(ns berry.lexical-analysis.error-handler)

(defn- raise-error
  [message {line :current-line
            column :current-column
            offset :offset}]
  (throw (java.text.ParseException. 
           (str message " at line " line ", column " column ".") offset)))

(defn unexpected-token
  [char context]
  (raise-error (str "Unexpected token " char) context))

(defn unexpected-end-of-input
  [context]
  (raise-error "Unexpected end of input" context))
