(ns berry.parsing.scan-literal
  (:require [berry.parsing.context-handler :refer [++ --]]
            [berry.parsing.character :refer :all]
            [berry.parsing.error-handler :refer :all]
            [berry.parsing.token :as token]))

(declare scan-by-example)

(defmulti scan-literal
  (fn [source context]
    (unicode-code-point (first source))))

(defmethod scan-literal 0x74
  [source context]
  (scan-by-example source '(0x74 0x72 0x75 0x65) context))

(defmethod scan-literal 0x66
  [source context]
  (scan-by-example source '(0x66 0x61 0x6c 0x73 0x65) context))

(defmethod scan-literal 0x6E 
  [source context]
  (scan-by-example source '(0x6E 0x75 0x6C 0x6C) context))

(defn- scan-by-example
  ([source example context]
    (scan-by-example source example [] context))
  ([source example buffer context]
    (cond
      (and (empty? source) (not (empty? example)))
      (unexpected-end-of-input (-- context))
      (empty? example)
      (token/literal buffer (-- context))
      :else
      (let [expected-char (first example)
            actual-char (first source)]
        (if (equal? expected-char actual-char)
          (recur (rest source)
                 (rest example)
                 (conj buffer actual-char)
                 (++ context))
          (unexpected-token actual-char context))))))
