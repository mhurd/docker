FROM openjdk:8u181-jdk-slim-stretch
WORKDIR /root
USER root
RUN /bin/sh -c 'apt-get update'
RUN /bin/sh -c 'apt-get install --no-install-recommends --no-install-suggests -y wget git maven'
RUN /bin/sh -c 'wget https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein && chmod +x lein && ./lein'
