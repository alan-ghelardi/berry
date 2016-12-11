(ns berry.lexical-analysis.scan-structural-test
  (:require [berry.lexical-analysis.context-handler :as context] 
            [berry.lexical-analysis.scan-structural :refer :all]
            berry.lexical-analysis.token
            [clojure.test :refer :all])
  (:import [berry.lexical_analysis.token Token Location]))

(deftest scan-structural-test
  
  (testing "scan-structural"
           
           (doseq [token ["{" "}" "[" "]" ":" ","]]
             
             (testing (str "Scanning the token " token)
                      
                      (is (= (Token. "structural" token (Location. 1 1) (Location. 1 1))
                             (scan-structural [token] context/begin)
                             
                             ))))))