(ns airports.db
  (:require [environ.core :refer [env]]
            [monger.core :as mg]
            [monger.collection :as mc]
            [monger.query :refer :all]
            monger.json))

(def db (:db (mg/connect-via-uri (env :mongodb-uri))))

(defn get-page-number [p]
  (if (nil? p) 0 (bigint p)))

(defn find-in-db [params]
  (let [p (:p params) filters (dissoc params :p)]
    (with-collection db "airports"
      (find filters)
      (paginate :page (get-page-number p) :per-page 25))))
