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

(defn digit?
  [char]
  (let [code-point (unicode-code-point char)]
    (and (>= code-point 0x30)
         (<= code-point 0x39))))

(def dot? (partial equal? 0x2E))

(def plus-sign? (partial equal? 0x2B))

(def minus-sign? (partial equal? 0x2D))

(defn exponent-sign? 
  [char]
  (or (equal? char 0x65)
      (equal? char 0x45)))

(defn quotation-mark?
  [char]
  (= (unicode-code-point char)
     0x0022))
