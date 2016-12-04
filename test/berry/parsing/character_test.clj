(ns berry.parsing.character-test
  (:require [berry.parsing.character :refer :all]
            [clojure.test :refer :all]))

(deftest character-test
  
  (testing "unicode-code-point"
           
           (is 123 (=  (unicode-code-point "{")))))
