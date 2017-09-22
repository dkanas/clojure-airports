(ns airports.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [cheshire.core :refer :all]))

(defn response [status data]
  {:status status
   :headers {"Content-Type" "application/json"}
   :body (generate-string data)})

(def ok (partial response 200))

(defroutes app-routes
  (GET "/" [] (ok {:a "b"}))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes api-defaults))
