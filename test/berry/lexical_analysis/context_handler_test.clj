(ns berry.lexical-analysis.context-handler-test
  (:require [berry.lexical-analysis.context-handler :refer :all]
            [clojure.test :refer :all]))

(deftest context-handler-test
  
  (testing "begin"
           
           (testing "It returns the initial context (lines, columns, offset, etc.) for the lexical analysis."
                    
                    (is (= {:start-line 1
                            :start-column 1
                            :current-line 1
                            :current-column 1
                            :offset 0}
                           begin))))
  
  (testing "++"
           
           (testing "It increments the current context, by advancing to next current column and increasing the offset"
                    
                    (is (= {:start-line 1
                            :start-column 1
                            :current-line 1
                            :current-column 2
                            :offset 1}
                           (++ begin)))))
  
  (testing "--"
           
           (testing "It decrements the current context, by  returning to previous column and decreasing the offset"
                    
                    (is (= {:start-line 1
                            :start-column 1
                            :current-line 3
                            :current-column 13
                            :offset 29}
                           (-- {:start-line 1
                                :start-column 1
                                :current-line 3
                                :current-column 14 
                                :offset 30}))))))
