(ns clojurejudge.coderunner 
  (:require [clojure.edn :as edn]))

(defn run [s] 
  (eval (edn/read-string s)))

