
Install helm3

 microk8s enable helm3	
 sudo snap install helm --classic
 microk8s.config view >~/.kube/config

 helm dependency update ./helm/demokafka/charts/applications/charts/producer/
 helm dependency update ./helm/demokafka/charts/applications/charts/consumer/
 
Split application and resource into seperate helm charts
 
 helm install --set-string global.buildVersion=0.0.1 --set-string global.env=dev dev-demokafka-applications ./helm/applications --dry-run
 helm install --set-string global.buildVersion=0.0.1 --set-string global.env=dev dev-demokafka-resources ./helm/resources --dry-run

Instructions:

Steps:
 Build (arguments: component, version)
   Build JAR
   Build Docker Image
   package Helm Chart
 Deploy (arguments: component, version, environment, environment-prototype)


Test redeployment, multi-environment previouse version should be removed.
Autogenerate service name with auto-generated URL.


Renamed port 8080 -> 80 (http://dev-demokafka-consumer/swagger-ui.html)


