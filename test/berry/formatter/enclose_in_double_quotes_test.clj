(ns berry.formatter.enclose-in-double-quotes-test
  (:require [berry.formatter.enclose-in-double-quotes :refer :all] 
            [clojure.test :refer :all]))

(deftest enclosing-in-double-quotes
  
  (testing "The double quotes must be inserted in the resulting string."
           
           (is (= "\"hello\"" (enclose-in-double-quotes "hello")))))
