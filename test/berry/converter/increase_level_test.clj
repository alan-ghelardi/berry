(ns berry.converter.increase-level-test
  (:require [berry.converter.increase-level :refer :all]
            [clojure.test :refer :all]))

(deftest increasing-current-level
  
  (testing "Given a hash with a :level keyword, it returns a new hash with the :level incremented by one."
           
           (is (= {:level 2 :foo "bar"} (increase-level {:level 1 :foo "bar"})))))
