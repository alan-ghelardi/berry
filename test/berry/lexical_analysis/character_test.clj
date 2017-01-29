(ns berry.lexical-analysis.character-test
  (:require [berry.lexical-analysis.character :refer :all]
            [clojure.test :refer :all]))

(deftest character-test
  
  (testing "true-code-points"
    
    (is (= '(0x74 0x72 0x75 0x65)
           true-code-points)))
  
  (testing "false-code-points"
    
    (is (= '(0x66 0x61 0x6c 0x73 0x65)
           false-code-points)))
  
  (testing "null-code-points"
    
    (is (= '(0x6E 0x75 0x6C 0x6C)
           null-code-points)))
  
  (testing "unicode-code-point"
    
    (testing "When a string is passed as parameter."
      
      (is (= 123 (unicode-code-point "{")))))
  
  (testing "When an integer is passed as parameter."
    
    (is (= 123 (unicode-code-point 123))))
  
  (testing "equal?"
    
    (is (true? (equal? 0x7B  "{"))))
  
  (testing "structural?"
    
    (doseq [token ["{" "}" "[" "]" ":" ","]]
      
      (testing (str "With the token " token)
        
        (is (true? (structural? token)))))
    
    (testing "With invalid tokens"
      
      (doseq [token ["(" ")" "^"]]
        
        (is (nil? (structural? token))))))
  
  (testing "digit"
    
    (testing "With digits from 0 to 9."
      
      (doseq [token ["0" "1" "2" "3" "4" "5" "6" "7" "8" "9"]]
        
        (is (true? (digit? token)))))
    
    (testing "With invalid tokens."
      
      (doseq [token ["a" "!" "," ")"]]
        
        (is (false? (digit? token))))))
  
  (testing "dot?"
    
    (testing "The character ."
      
      (is (true? (dot? "."))))
    
    (testing "An invalid character."
      
      (is (false? (dot? ";"))))) 
  
  (testing "plus-sign?"
    
    (testing "The character +."
      
      (is (true? (plus-sign? "+"))))
    
    (testing "An invalid character."
      
      (is (false? (plus-sign? "!")))))
  
  (testing "minus-sign?" 
    
    (testing "The character -."           
      
      (is (true? (minus-sign? "-"))))
    
    (testing "An invalid chracter."           
      
      (is (true? (minus-sign? "-")))))
  
  (testing "exponent-sign?"
    
    (testing "The character e"
      
      (is (true? (exponent-sign? "e"))))
    
    (testing "The character E"
      
      (is (true? (exponent-sign? "E"))))
    
    (testing "An invalid character."
      
      (is (false? (exponent-sign? "a")))))

  (testing "quotation-mark?"

    (testing "With a quotation mark"

      (is (true? (quotation-mark? "\"")))
      (testing "With an arbitrary character."

        (is (false? (quotation-mark? "a")))))))
