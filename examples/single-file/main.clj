#!/usr/bin/env boot
(set-env!
 :dependencies '[[org.clojure/clojure "1.7.0"]
                 [funcool/catacumba "0.3.2"]])

(require '[catacumba.core :as ct])

(defn home-page
  [content]
  "Hello world")

(def app
  (ct/routes [[:get home-page]]))

(defn -main
  "The main entry point to your application."
  [& args]
  (let [lt (java.util.concurrent.CountDownLatch. 1)]
    (ct/run-server app {:port 5050 :basedir "."})
    (.await lt)))

