(ns berry.converter.to-member-test
  (:require [berry.converter.default-options :refer :all]
            [berry.converter.to-member :refer :all]
            [clojure.test :refer :all]))

(deftest transformation-into-json-member
  
  (testing "Without prettifying the member and keeping the default options."
           
           (is (= "\"fullName\":\"John Doe\"")
               (to-member [:full-name "John Doe"]
                          (into default-options {:prettify? false}))))
  
  (testing "Prettifying the member and keeping the default options."
           
           (is (= "\n\t\t\"acceptanceRate\" : 63.5"
                  (to-member [:acceptance-rate 63.5]
                             (into default-options {:level 1}))))))
