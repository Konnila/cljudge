(ns clojurejudge.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World and also Hello Tuomo! Tinkering with Circle CI and clojure project autodeploy :-)")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
