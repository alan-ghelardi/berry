(ns berry.parsing.character-test
  (:require [berry.parsing.character :refer :all]
            [clojure.test :refer :all]))

(deftest character-test
  
  (testing "unicode-code-point"
           
           (testing "With a string as parameter."
                    
                    (is 123 (=  (unicode-code-point "{")))))
  
  (testing "With an integer as parameter"
           
           (is (= 123 (unicode-code-point 123))))
  
  (testing "equal?"
           
           (is (= true (equal? 0x7B  "{")))))
