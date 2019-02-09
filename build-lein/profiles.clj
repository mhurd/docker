{:user {:mirrors {#".+" {:url "http://nexus.home:8082/repository/maven-group/"}}
        :repositories [["snapshots" {:id "neux-home-snapshots" 
                                     :url "http://nexus.home:8082/repository/maven-snapshots"}]
                       ["releases" {:id "nexus-home-releases"
                                    :url "http://nexus.example.com:8081/nexus/content/repositories/releases" 
                                    :sign-releases false}]]}
  :auth {:repository-auth {#"nexus.home" {:username "jenkins-build" :password "jenkins-build"}}}}
