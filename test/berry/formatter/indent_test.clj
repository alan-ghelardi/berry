(ns berry.formatter.indent-test
  (:require [berry.formatter.indent :refer :all]
            [clojure.test :refer :all]))

(deftest indentation
  
  (testing "tab"
           
           (testing "Yields a given number of tabs."
                    
                    (is (= "\t\t" (tab 2)))))
  
  (testing "space"
           
           (testing "Yields a given number of white spaces"
                    
                    (is (= "   " (space 3)))))
  
  (testing "indent"
           
           (testing "Skips the indentation when the keyword :prettify? is false"
                    
                    (is (= "hello" (indent "hello" {:prettify? false}))))
           
           (testing "Adds two tabs."
                    
                    (is (= "\t\thello" (indent "hello" {
                                                        :prettify? true
                                                        :indent-style tab
                                                        :indent-size 2
                                                        :level 1
                                                        }))))
           
           (testing "Adds three spaces."
                    
                    (is (= "   hello" (indent "hello" {
                                                       :prettify? true
                                                       :indent-style space
                                                       :indent-size 1
                                                       :level 3
                                                       }))))
           
           (testing "Adds four tabs."
                    
                    (is (= "\t\t\t\thello" (indent "hello" {
                                                            :prettify? true
                                                            :indent-style tab
                                                            :indent-size 2
                                                            :level 2
                                                            }))))
           
           ))
