(ns clojurejudge.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clojurejudge.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World and also Hello Tuomo! Tinkering with Circle CI and clojure project autodeploy :-)"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
