(ns berry.lexical-analysis.scan-number-test
  (:require [berry.lexical-analysis.context-handler :as context] 
            [berry.lexical-analysis.scan-number :refer :all]
            berry.lexical-analysis.token
            [clojure.test :refer :all])
  (:import [berry.lexical_analysis.token Token Location]))

(deftest scan-number-test
  
  (testing "When the input ends unexpectedly."
           
           (is (thrown-with-msg? java.text.ParseException #"Unexpected end of input at line 1, column 1."
                                 (scan-number '("-") context/begin))))
  
  (testing "When a simple integer is given."
           
           (is (= (Token. "number" "21" (Location. 1 1) (Location. 1 2))
                  (scan-number '("2" "1") context/begin))))
  
  (testing "When a non-digit appears after the integer."
           
           (is (= (Token. "number" "14" (Location. 1 1) (Location. 1 2))
                  (scan-number '("1" "4" ",") context/begin))))
  
  (testing "When a decimal is given."
           
           (is (= (Token. "number" "1250.97" (Location. 1 1) (Location. 1 7))
                  (scan-number '("1" "2" "5" "0" "." "9" "7") context/begin))))
  
  (testing "When a non-digit appears after the decimal."
           
           (is (= (Token. "number" "14.5" (Location. 1 1) (Location. 1 4))
                  (scan-number '("1" "4" "." "5" ",") context/begin))))
  
  (testing "When the decimal ends in a dot."
           
           (is (thrown-with-msg? java.text.ParseException #"Unexpected end of input at line 1, column 4."
                                 (scan-number '("3" "2" "0" ".") context/begin))))
  
  (testing "When the decimal ends with an unexpected token."
           
           (is (thrown-with-msg? java.text.ParseException #"Unexpected token a at line 1, column 4."
                                 (scan-number '("4" "5" "." "a") context/begin))))
  
  (testing "Numbers with an exponential part."
           
           (testing "When the exponent sign is `e`."
                    
                    (is (= (Token. "number" "3e10" (Location. 1 1) (Location. 1 4))
                           (scan-number '("3" "e" "1" "0") context/begin))))
           
           (testing "When the exponent sign is `E`."
                    
                    (is (= (Token. "number" "3E10" (Location. 1 1) (Location. 1 4))
                           (scan-number '("3" "E" "1" "0") context/begin))))
           
           (testing "When there is a plus sign after the exponent sign."
                    
                    (is (= (Token. "number" "3e+10" (Location. 1 1) (Location. 1 5))
                           (scan-number '("3" "e" "+" "1" "0") context/begin))))
           
           (testing "When there is a minus sign after the exponent sign."
                    
                    (is (= (Token. "number" "3e-10" (Location. 1 1) (Location. 1 5))
                           (scan-number '("3" "e" "-" "1" "0") context/begin))))
           
           (testing "When the number ends with the exponent sign."
                    
                    (is (thrown-with-msg? java.text.ParseException #"Unexpected end of input at line 1, column 2."
                                          (scan-number '("3" "e") context/begin))))
           
           (testing "When the number ends with the plus sign."
                    
                    (is (thrown-with-msg? java.text.ParseException #"Unexpected end of input at line 1, column 3."
                                          (scan-number '("3" "e" "+") context/begin))))
           
           (testing "When the number ends with the minus sign."
                    
                    (is (thrown-with-msg? java.text.ParseException #"Unexpected end of input at line 1, column 3."
                                          (scan-number '("3" "e" "-") context/begin))))
           
           (testing "When the number contains an unexpected token."
                    
                    (is (thrown-with-msg? java.text.ParseException #"Unexpected token x at line 1, column 3."
                                          (scan-number '("3" "e" "x" "-" "5") context/begin))))
           
           (testing "When the exponent appears in a decimal number."
                    
                    (is (= (Token. "number" "3.5E-6" (Location. 1 1) (Location. 1 6))
                           (scan-number '("3" "." "5" "E" "-" "6") context/begin))))))