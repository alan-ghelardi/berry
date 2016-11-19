(ns berry.formatter.wrap)

(defn wrap
  [text {prettify? :prettify?}]
  (str 
    (if prettify? "\n" "")
      text))
