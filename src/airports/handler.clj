(ns airports.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [cheshire.core :refer :all]
            [airports.db :refer [find-in-db]]))

(defn response [status data]
  {:status status
   :headers {"Content-Type" "application/json"}
   :body (generate-string data)})

(def ok (partial response 200))

(def filters [:iata :continent :name :iso :type :size :status :lon :lat :p])
(defn find-airports [params]
  (ok (find-in-db (select-keys params filters))))

(defroutes app-routes
  (GET "/" {params :params} (find-airports params))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes api-defaults))
