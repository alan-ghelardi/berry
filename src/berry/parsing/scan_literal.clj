(ns berry.parsing.scan-literal
  (:require [berry.parsing.context-handler :refer [++ --]]
            [berry.parsing.character :refer :all]
            [berry.parsing.error-handler :refer :all]
            [berry.parsing.token :as token]))

(declare scan)

(defmulti scan-literal
  (fn [source context]
    (unicode-code-point (first source))))

(defmethod scan-literal (first true-code-points) 
  [source context]
  (scan source true-code-points context))

(defmethod scan-literal (first false-code-points) 
  [source context]
  (scan source false-code-points context))

(defmethod scan-literal (first null-code-points) 
  [source context]
  (scan source null-code-points context))

(defn- scan
  ([source valid-tokens context]
    (scan source valid-tokens [] context))
  ([source valid-tokens buffer context]
    (cond
      (and (empty? source) (not (empty? valid-tokens)))
      (unexpected-end-of-input (-- context))
      (empty? valid-tokens)
      (token/literal buffer (-- context))
      :else
      (let [expected-char (first valid-tokens)
            actual-char (first source)]
        (if (equal? expected-char actual-char)
          (recur (rest source)
                 (rest valid-tokens)
                 (conj buffer actual-char)
                 (++ context))
          (unexpected-token actual-char context))))))
