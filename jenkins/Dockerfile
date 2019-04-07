FROM jenkins/jenkins:2.171
USER root
RUN /bin/sh -c 'apt-get update'
RUN /bin/sh -c 'apt-get install --no-install-recommends --no-install-suggests -y less vim apt-transport-https ca-certificates curl gnupg-agent software-properties-common git maven'
RUN /bin/sh -c 'curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add --no-tty -'
RUN /bin/sh -c 'add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable"'
RUN /bin/sh -c 'apt-get update'
RUN /bin/sh -c 'apt-get install -y docker-ce docker-ce-cli'
RUN /bin/sh -c 'usermod -aG docker jenkins'
RUN /bin/sh -c 'echo "jenkins ALL=(ALL) NOPASSWD: /usr/bin/docker" >> /etc/sudoers'
COPY nexus.home.certificate.pem nexus.home.certificate.pem
RUN /bin/sh -c 'keytool -noprompt -import -alias nexus.home -file nexus.home.certificate.pem -keystore cacerts -storepass changeit'
RUN /bin/sh -c '/usr/lib/jvm/java-8-openjdk-amd64/bin/keytool -noprompt -import -alias nexus.home -file nexus.home.certificate.pem -keystore /usr/lib/jvm/java-8-openjdk-amd64/jre/lib/security/cacerts -storepass changeit'
USER jenkins
RUN /bin/sh -c 'mkdir -p /var/jenkins_home/.m2/repository'
COPY settings.xml /var/jenkins_home/.m2/settings.xml
