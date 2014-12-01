(defproject hydrogen "0.1.0-SNAPSHOT"
  :description "todo"
  :url "none"
  :min-lein-version "2.4"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.2.0"]
                 [ring/ring-defaults "0.1.2"]
                 [org.immutant/web "2.0.0-beta1"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler hydrogen.core.handler/app}
  :profiles {:uberjar {:aot [hydrogen.core.main]}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]}}
  :main hydrogen.core.main
  :uberjar-name "hydrogen-standalone.jar")
  
