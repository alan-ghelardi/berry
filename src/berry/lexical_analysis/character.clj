(ns berry.lexical-analysis.character)

(def true-code-points '(0x74 0x72 0x75 0x65))

(def false-code-points '(0x66 0x61 0x6c 0x73 0x65))

(def null-code-points '(0x6E 0x75 0x6C 0x6C))

(defn unicode-code-point
  [char]
  (if (number? char)
    char
    (.codePointAt char 0)))

(defn equal?
  [a-char other-char]
  (= (unicode-code-point a-char) (unicode-code-point other-char)))

(defn structural?
  [char]
  (let [structural-code-points '(0x7B ;; left curly bracket 
                                  0x7D ;; right curly bracket 
                                  0x5B ;; left square bracket
                                  0x5D ;; right square bracket  
                                  0x3A ;; colon 
                                  0x2C)] ;; comma
    (some #(equal? % char)
          structural-code-points)))
