## Nexus3 in Docker
Uses the standard Nexus3 image as a base, adds nothing else for now but we'll build an image from this so we can modify later.
### Running
```bash
docker run --restart always -d --name nexus -v nexus-data:/nexus-data -p 8082:8081 mhurd/nexus3:3.15.2
```
