(ns hydrogen.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [liberator.core :refer [defresource]]
            [ring.util.response :refer [redirect]]
            [ring.middleware.json :as middleware]))

(defresource service [body]
  :available-media-types ["application/json"]
  :handle-ok {:uri (str (:uri body))})

(defresource schema [body]
  :available-media-types ["application/json"]
  :handle-ok {:name "person" :fiels [{:type "string" 
                                    :id "name"
                                    :display-name "Name"
                                    :discraption "some string"} 
                                   {:type "number"
                                    :id "age"
                                    :display-name "Age"
                                    :discraption "some string too"}
                                   ]})

(defroutes app-routes
  (GET "/schema" [body] schema)
  (GET "/service/*" [body] service)
  (GET "/" {c :context} (redirect (str c "/index.html"))) 
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-response)))
