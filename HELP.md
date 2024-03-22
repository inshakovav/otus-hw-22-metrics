# Spring Boot REST-service
The Spring Boot service expose CRUD to the user.  
The database credentials are specified in ENV.  
ENV are specified in secret.yaml

### Test requests
Actuator:
curl localhost:8080/actuator | json_pp

Get metrics:
curl http://localhost:8080/actuator/prometheus

minikube start
minikube dashboard # Web UI

# Установка Prometheus, Operator, Grafana,
# Adn Update Prometheus values
helm install stack prometheus-community/kube-prometheus-stack -f ./k8s/prometheus.yaml

docker build -t metrics-demo:v1 .

