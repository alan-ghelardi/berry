(ns berry.parsing.error-handler-test
  (:require [berry.parsing.error-handler :refer :all]
            [clojure.test :refer :all]))

(deftest error-handler-test
  
  (testing "Unexpected token error."
           
           (is (thrown-with-msg? java.text.ParseException #"Unexpected token . at line 10, column 4."
               (unexpected-token "." {:line 10 :column 4 :offset 30})))))
