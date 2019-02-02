Get the latest LTS version.
```bash
docker pull jenkins/jenkins:lts
```
You can run this in detached mode using:
```bash
docker run -d -v jenkins_home:/var/jenkins-home -p 8081:8080 -p 50000:50000 mhurd/jenkins:1.0
```
This will create a volume names *jenkins_home* and map port *8081* on the host to *8080* on the container. You need to get the log output to obtain the generated admin password on the first run using the following command, the CONTAINER_ID is returned on stdout by the previous command:
```bash
docker logs CONTAINER_ID
```
