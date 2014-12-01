(ns hydrogen.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [liberator.core :refer [defresource]]
            [ring.middleware.json :as middleware]))

(defresource service [body]
  :available-media-types ["application/json"]
  :handle-ok {:a (str body)})

(defroutes app-routes
  (GET "/service/*" [body] service)
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-response)))
