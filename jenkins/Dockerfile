FROM jenkins/jenkins:2.163
USER root
RUN /bin/sh -c 'apt-get update'
RUN /bin/sh -c 'apt-get install --no-install-recommends --no-install-suggests -y less vim apt-transport-https ca-certificates curl gnupg-agent software-properties-common git maven'
RUN /bin/sh -c 'curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add --no-tty -'
RUN /bin/sh -c 'add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable"'
RUN /bin/sh -c 'apt-get update'
RUN /bin/sh -c 'apt-get install -y docker-ce docker-ce-cli'
RUN /bin/sh -c 'usermod -aG docker jenkins'
RUN /bin/sh -c 'echo "jenkins ALL=(ALL) NOPASSWD: /usr/bin/docker" >> /etc/sudoers'
USER jenkins
RUN /bin/sh -c 'cd /var/jenkins_home && wget https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein && chmod +x lein && ./lein'
