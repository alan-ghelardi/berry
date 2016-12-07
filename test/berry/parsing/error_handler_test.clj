(ns berry.parsing.error-handler-test
  (:require [berry.parsing.error-handler :refer :all]
            [clojure.test :refer :all]))

(deftest error-handler-test
  
  (testing "unexpected-token"
           
           (is (thrown-with-msg? java.text.ParseException #"Unexpected token . at line 10, column 4."
                                 (unexpected-token "." {:current-line 10 :current-column 4 :offset 30}))))
  
  (testing "unexpected-end-of-input")
  
  (is (thrown-with-msg? java.text.ParseException #"Unexpected end of input at line 20, column 5."
                       (unexpected-end-of-input {:current-line 20 :current-column 5 :offset 50}))))
