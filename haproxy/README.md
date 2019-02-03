## HAProxy
We want to run a HAProxy instance in a container so that we can route http requests to the correct container on the server. 
To set this up we use the official HAProxy docker image as a basis (https://hub.docker.com/_/haproxy).
```bash
FROM haproxy:1.9.3-alpine
```
and then simply copy in our custom config.
```bash
COPY haproxy.cfg /usr/local/etc/haproxy/haproxy.cfg
```
