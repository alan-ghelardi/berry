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
                    
                    (is 123 (= (unicode-code-point "{")))))
  
  (testing "When an integer is passed as parameter."
           
           (is (= 123 (unicode-code-point 123))))
  
  (testing "equal?"
           
           (is (= true (equal? 0x7B  "{")))))
