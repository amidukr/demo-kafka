cat <<-EOF
---
apiVersion: apps/v1
kind: Deployment
metadata:
  name: $KD_TARGET_APPLICATION_NAME-deployment
spec:
  replicas: $KD_TARGET_APPLICATION_REPLICAS
  selector:
    matchLabels:
      app: $KD_TARGET_APPLICATION_NAME-application
  template:
    metadata:
      labels:
        app: $KD_TARGET_APPLICATION_NAME-application
    spec:
      containers:
      - name: $KD_TARGET_APPLICATION_NAME
        image: $KD_TARGET_DOCKER_IMAGE
        imagePullPolicy: IfNotPresent
        ports:
        - containerPort: $KD_TARGET_APPLICATION_PORT
---
apiVersion: v1
kind: Service
metadata:
  name: $KD_TARGET_APPLICATION_NAME
  labels:
    app: $KD_TARGET_APPLICATION_NAME-service
spec:
  ports:
  - name: http
    port: 8080
    targetPort: $KD_TARGET_APPLICATION_PORT
  selector:
    app: $KD_TARGET_APPLICATION_NAME-application

EOF

