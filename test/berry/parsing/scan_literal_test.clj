(ns berry.parsing.scan-literal-test
  (:require [berry.parsing.context-handler :as context] 
            [berry.parsing.scan-literal :refer :all]
            berry.parsing.token
            [clojure.test :refer :all])
  (:import [berry.parsing.token Token Location]))

(deftest scan-literal-test
  
  (testing "With a true literal."
           
           (let [true-literal (Token. "literal" "true" (Location. 1 1) (Location. 1 4))]
             
             (is (= true-literal
                    (scan-literal '("t" "r" "u" "e") context/begin)))))
  
  (testing "With a false literal."
           
           (let [false-literal (Token. "literal" "false" (Location. 1 1) (Location. 1 5))]
             
             (is (= false-literal
                    (scan-literal '("f" "a" "l" "s" "e") context/begin)))))
  
  (testing "With a null literal."
           
           (let [null-literal (Token. "literal" "null" (Location. 1 1) (Location. 1 4))]
             
             (is (= null-literal
                    (scan-literal '("n" "u" "l" "l") context/begin)))))
  
  
  
  )
