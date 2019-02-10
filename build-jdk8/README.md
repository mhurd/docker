## Building the base JDK 8 build image
```bash
docker build development/docker/build-jdk8 --tag mhurd/build-jdk8:1.0 --build-arg "NEXUS_USER_ARG=user" --build-arg "NEXUS_PASSWORD_ARG=password"
```
