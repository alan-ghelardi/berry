(ns berry.formatter.extract-name-test
  (:require [berry.formatter.extract-name :refer :all]
            [clojure.test :refer :all]))

(deftest name-extraction
  
  (testing "When a string is given, it returns the own string."
           
           (is (= "email-address" (extract-name "email-address"))))
  
  (testing "With keywords."
           
           (testing "The colon must be removed from the resulting string."
                    
                    (is (= "user-name" (extract-name :user-name)) ))
           
           (testing "When there is a question mark in the keyword, it must be removed from the resulting string."
                    
                    (is (= "hired" (extract-name :hired?))))))
