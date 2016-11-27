(ns berry.converter.to-primitives-test
  (:require [berry.converter.to-primitives :refer :all]
            [clojure.test :refer :all]))

(deftest primitive-types-conversion
  (let [options {}]
    
    (testing "to-boolean"
             
             (is (and
                   (= "true" (to-boolean true options)))
                 (= "false" (to-boolean false options))))
    
    (testing "to-null"
             
             (is (= "null" (to-null nil options))))
    
    (testing "to-number"
             
             (testing "Floating-point numbers"
                      
                      (is (= "15.3" (to-number 15.3 options))))
             
             (testing "Integers."
                      
                      (is (= "21" (to-number 21 options)))))
    
    (testing "to-string"
             
             (is (= "\"hello\"" (to-string "hello" options))))))
