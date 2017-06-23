########################################################
# Dockerfile per l'applicazione sentence / word service 
########################################################

FROM frolvlad/alpine-oraclejdk8 

ADD build/libs/BandinfoS2Album-0.0.1-SNAPSHOT.jar s2.jar

EXPOSE 8080

ENTRYPOINT ["/usr/bin/java", "-Xmx128m", "-Xms128m"]

CMD ["-jar", "s2.jar"]
