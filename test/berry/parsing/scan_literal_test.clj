(ns berry.parsing.scan-literal-test
  (:require [berry.parsing.context-handler :as context] 
            [berry.parsing.scan-literal :refer :all]
            berry.parsing.token
            [clojure.test :refer :all])
  (:import [berry.parsing.token Token Location]))

(deftest scan-literal-test
  
  (testing "When a true literal is analyzed."
           
           (let [true-literal (Token. "literal" "true" (Location. 1 1) (Location. 1 4))]
             
             (is (= true-literal
                    (scan-literal '("t" "r" "u" "e") context/begin)))))
  
  (testing "When a false literal is analyzed."
           
           (let [false-literal (Token. "literal" "false" (Location. 1 1) (Location. 1 5))]
             
             (is (= false-literal
                    (scan-literal '("f" "a" "l" "s" "e") context/begin)))))
  
  (testing "When a null literal is analyzed."
           
           (let [null-literal (Token. "literal" "null" (Location. 1 1) (Location. 1 4))]
             
             (is (= null-literal
                    (scan-literal '("n" "u" "l" "l") context/begin)))))
  
  (testing "When an unexpected token is found in the sequence."
           
           (is (thrown-with-msg? java.text.ParseException #"Unexpected token y at line 1, column 3."
                                 (scan-literal '("t" "r" "y" "e") context/begin)))
           
           (testing "When the input terminates unexpectedly."
                    
                    (is (thrown-with-msg? java.text.ParseException #"Unexpected end of input at line 1, column 4."
                                          
                                          (scan-literal '("f" "a" "l" "s") context/begin))))))
