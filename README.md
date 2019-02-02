# docker
Various docker bits n' pieces and notes.

## Installing on Ubuntu
First remove any old versions.
```bash
sudo apt-get remove docker docker-engine docker.io containerd runc
```
Then update apt so that it can access repositories over ssh.
```bash
sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common
```
Add docker's official GPG key.
```bash
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
```
Check you have the key.
```bash
$ sudo apt-key fingerprint 0EBFCD88
    
pub   rsa4096 2017-02-22 [SCEA]
      9DC8 5822 9FC7 DD38 854A  E2D8 8D81 803C 0EBF CD88
uid           [ unknown] Docker Release (CE deb) <docker@docker.com>
sub   rsa4096 2017-02-22 [S]
```
Now add the *stable* repository.
```bash
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
```
Update the package index.
```bash
sudo apt-get update
```
Install the latest version of Docker CE and containerd.
```bash
sudo apt-get install docker-ce docker-ce-cli containerd.io
```
Add your user to the *docker* group.
```bash
sudo usermod -aG docker your-user
```
