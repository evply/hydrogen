(ns hydrogen.core.main 
  (:require [hydrogen.core.handler :as handler]
            [immutant.web :as web])
  (:gen-class))

(defn -main [& args]
  (web/run handler/app args))
