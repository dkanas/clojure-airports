# clojure-airports

Hosted version: http://clojure-airports.herokuapp.com

This is a simple API using Clojure and MongoDB for querying airport data.
Example airport document:
```
{
  "iata": "SOY", // the airport code
  "_id": "59c7f46209bfa70e7616d873",
  "continent": "EU", // uppercase
  "name": "Stronsay Airport",
  "iso": "GB", // ISO country code, uppercase
  "type": "airport", // type: seaplanes, heliport, airport, closed
  "size": "small", // small, medium, large, null
  "status": 1, // 1 - active, 0 - inactive
  "lon": "-2.640495",
  "lat": "59.154053"
}
```

All of the object fields except for _id can be used as query params when calling the API. It also supports pagination.

Example:
```
https://clojure-airports.herokuapp.com/?iso=US&size=small&p=2
```

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running
First, set a `MONGODB_URI` env variable with a MongoDB connection URI.

Then you can start the app by running:

    lein ring server
