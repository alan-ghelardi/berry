(ns berry.formatter.wrap-test
  (:require [berry.formatter.wrap :refer :all]
            [clojure.test :refer :all]))

(deftest line-wrapping
  
  (testing "Skips the wrapping process when the keyword :prettify? is false."
           
           (is (= "hello" (wrap "hello" {:prettify? false}))))
  
  (testing "Wraps the text."
           
           (is (= "\nhello" (wrap "hello" {:prettify? true})))))
