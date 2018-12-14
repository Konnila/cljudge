(ns clojurejudge.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as resp]
            [clojurejudge.coderunner :as runner]))

(defroutes app-routes
  (GET "/" [] (resp/redirect "/frontpage.html"))
  (POST "/submit" req (runner/run (get (get req :form-params) "code")))
  (route/not-found "Not Found")) 

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
