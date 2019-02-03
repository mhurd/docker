## Jenkins in Docker
There are a few things we want to be able to do in this dockerised verison of Jenkins so we'll need to make some additons to the official version (https://github.com/jenkinsci/docker/blob/master/README.md). We'll choose a specific version so we can control upgrades.
```bash
FROM jenkins/jenkins:2.163
```
First we pull in the dependencies required to install Docker (and also install mvn and git whilst we're there), note we need to be *root* to do these steps, we'll switch back to the *jenkins* user when we're done:
```bash
USER root
RUN /bin/sh -c 'apt-get update'
RUN /bin/sh -c 'apt-get install --no-install-recommends --no-install-suggests -y less vim apt-transport-https ca-certificates curl gnupg-agent software-properties-common git maven'
```
Next we install docker (no containerd as we'll be piggy-backing o.n the host docker):
```bash
RUN /bin/sh -c 'curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add --no-tty -'
RUN /bin/sh -c 'add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable"'
RUN /bin/sh -c 'apt-get update'
RUN /bin/sh -c 'apt-get install -y docker-ce docker-ce-cli'
RUN /bin/sh -c 'usermod -aG docker jenkins'
```
Lastly we have to add *jenkins* to the sudoers file so it can access the docker socker on the host we'll be mounting into the container. Then we switch the user back to jenkins.
```bash
RUN /bin/sh -c 'echo "jenkins ALL=(ALL) NOPASSWD: /usr/bin/docker" >> /etc/sudoers'
USER jenkins
```
We can now build (and tag this image):
```bash
docker build jenkins --tag mhurd/jenkins:1.0
```
You can run this in detached mode using:
```bash
docker run --restart always --name jenkins -d -v /var/run/docker.sock:/var/run/docker.sock -v jenkins-home:/var/jenkins_home -p 8081:8080 -p 50000:50000 mhurd/jenkins:1.0
```
This will do the following:
- set the restart policy to always to it'll start-up on reboot.
- name the container *jenkins* for ease of reference.
- run in daemon mode.
- mount the host docker socket into the container so the jenkins container can use docker.
- mount volume named *jenkins-home* into the container, this will be where all the jenkins files will be stored.
- map port *8081* on the host to *8080* on the container (port *8080* was taken on my host). 
- map port *50000* on the host to port *50000* on the container, this is used by remote build slaves.
- finally we indicate the image we want to use.

On the first run you'll need to check the jenkins logs to obtain the generated admin password using the following command. This will be required when setting up Jenkins the first time.
```bash
docker logs jenkins
```
### Useful links
Running Jenkins behind HAProxy: https://wiki.jenkins.io/display/JENKINS/Running+Jenkins+behind+HAProxy
