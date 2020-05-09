
Install helm3

 microk8s enable helm3	
 sudo snap install helm --classic
 microk8s.config view >~/.kube/config

Instructions:

Steps:
 Build (arguments: component, version)
   Build JAR
   Build Docker Image
   package Helm Chart
 Deploy (arguments: component, version, environment, environment-prototype)


Test redeployment, multi-environment previouse version should be removed.
Autogenerate service name with auto-generated URL.



