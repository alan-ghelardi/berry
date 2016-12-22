(ns berry.lexical-analysis.scan-number
  (:require [berry.lexical-analysis.context-handler :refer [++ --]]
            [berry.lexical-analysis.character :refer :all]
            [berry.lexical-analysis.error-handler :refer :all]
            [berry.lexical-analysis.token :as token]))

(declare scan-digits handle-end-of-input handle-non-digit 
         ends-with-digit? scan-fractional-part scan-exponential-part)

(defn scan-number
  ([input context]
    (let [char (first input)]
      (scan-number (rest input) [char]  (++ context))))
  ([input buffer context]
    (let [char (first input)] 
      (cond
        (empty? input)
        (handle-end-of-input buffer context)
        (dot? char)
        (scan-fractional-part (rest input)
                              (conj buffer char)
                              (++ context))
        (exponent-sign? char)
        (scan-exponential-part (rest input)
                               (conj buffer char)
                               (++ context))
        (not (digit? char))
        (handle-non-digit char buffer context) 
        :else
        (recur (rest input)
               (conj buffer char)
               (++ context))))))

(defn- handle-end-of-input 
  [buffer context]
  (if (digit? (last buffer))
    (token/number buffer (-- context))
    (unexpected-end-of-input (-- context))))

(defn- scan-fractional-part
  [source buffer context]
  (let [char (first source)]
    (cond
      (nil? char)
      (handle-end-of-input buffer context)
      (and (exponent-sign? char) (ends-with-digit? buffer))
      (scan-exponential-part (rest source)
                             (conj buffer char)
                             (++ context))
      (not (digit? char))
      (handle-non-digit char buffer context)
      :else
      (recur (rest source)
             (conj buffer char)
             (++ context)))))

(defn- scan-exponential-part
  [source buffer context]
  (let [char (first source)]
    (cond
      (nil? char)
      (unexpected-end-of-input (-- context))
      (or (plus-sign? char) (minus-sign? char) (digit? char))
      (scan-digits (rest source)
                   (conj buffer char)
                   (++ context))
      :else
      (unexpected-token char context))))

(defn- scan-digits
  [source buffer context]
  (let [char (first source)]
    (cond
      (empty? source)
      (handle-end-of-input buffer context)
      (not (digit? char)) 
      (handle-non-digit char buffer context)
      :else
      (recur (rest source)
             (conj buffer char)
             (++ context)))))

(defn- handle-non-digit
  [char buffer context]
  (if (ends-with-digit? buffer)
    (token/number buffer (-- context))
    (unexpected-token char context)))

(defn- ends-with-digit?
  [buffer]
  (digit? (last buffer)))
