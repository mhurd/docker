FROM openjdk:8u181-jdk-slim-stretch
WORKDIR /root
USER root
RUN /bin/sh -c 'apt-get update'
RUN /bin/sh -c 'apt-get install --no-install-recommends --no-install-suggests -y wget git maven'
RUN /bin/sh -c 'wget https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein && chmod +x lein && ./lein'
ARG NEXUS_USER_ARG
ARG NEXUS_PASSWORD_ARG
ENV NEXUS_USER=$NEXUS_USER_ARG
ENV NEXUS_PASSWORD=$NEXUS_PASSWORD_ARG
COPY settings.xml settings.xml
RUN /bin/sh -c 'chmod +r settings.xml'
COPY nexus.home.certificate.pem nexus.home.certificate.pem
RUN /bin/sh -c '/usr/lib/jvm/java-8-openjdk-amd64/bin/keytool -noprompt -import -alias nexus.home -file nexus.home.certificate.pem -keystore /usr/lib/jvm/java-8-openjdk-amd64/jre/lib/security/cacerts -storepass changeit'
