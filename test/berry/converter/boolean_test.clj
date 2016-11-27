(ns berry.converter.boolean-test
  (:require [berry.converter.boolean :refer :all]
            [clojure.test :refer :all]))

(deftest boolean-checking
  
  (testing "Given boolean types, it returns true."
           
           (is (and (= true (boolean? true))
                    (= true (boolean? false)))))
  
  (testing "Given non-boolean types, it returns false."
           
           (is (and
                 (= false (boolean? 16))
                 (is (= false (boolean? "foo")))))))
