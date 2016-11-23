(ns berry.formatter.camelize-test
  (:require [berry.formatter.camelize :refer :all] 
    [clojure.test :refer :all]))

(deftest camel-case
  
  (testing "A word with underlines."
           
           (is (= "firstName" (camelize "first_name"))))
  
  (testing "A word with dashes."
           
           (is (= "anotherAnyWord" (camelize "another-any-word")))))
