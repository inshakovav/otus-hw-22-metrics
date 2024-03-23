# Spring Boot REST-service
The Spring Boot service expose CRUD to the user.  
The database credentials are specified in ENV.  
ENV are specified in secret.yaml

### Test requests
Actuator:
```bash
curl localhost:8080/actuator | json_pp
```

Get metrics:
```bash
curl http://localhost:8080/actuator/prometheus

minikube start
minikube dashboard # Web UI
```
Установка Prometheus, Operator, Grafana,
And Update Prometheus values
```bash
helm install stack prometheus-community/kube-prometheus-stack -f ./k8s_prometheus/prometheus.yaml
```

### Create docker Image
```bash
mvn package
```
`
var 1. Only build to local
```bash
docker build -t alxinsh/metrics-demo:v2 .
```

var 2. Build and push to the Docker hub
```bash
docker image build -t alxinsh/metrics-demo:v2 .
docker push alxinsh/metrics-demo:v2
```

### Deploy service into K8s
```bash
kubectl apply -f ./k8s/
```

### Cleanup
```bash
kubectl delete -f ./k8s/ 
```
