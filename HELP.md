# Spring Boot REST-service
Spring Boot application provides endpoints:  
api/a - with random delay from 0 ms to 300 ms  
api/b - with random delay from 200 ms to 400 ms  

The Metrics library provides endpoint metrics:  
actuator/prometheus

Prometheus collect these metrics and stores them in a time serial database.  
Grafana calculates metrics using PomeQL-queries and provides dashboards.

### Test requests
Actuator:
```bash
curl localhost:8090/actuator | json_pp
```

Get metrics:
```bash
curl http://localhost:8090/actuator/prometheus

minikube start
minikube dashboard # Web UI
```
### Установка Prometheus, Operator, Grafana,
And Update Prometheus values
```bash
helm install stack prometheus-community/kube-prometheus-stack -f ./k8s_prometheus/prometheus.yaml
```

### Deploy an application to Kubernetes
Create docker Image
```bash
mvn package
```
`
var 1. Only build to local.
! Doesn't work for K8s, only for Docker.
```bash
docker build -t alxinsh/metrics-demo:v2 .
```

var 2. Build and push to the Docker hub
```bash
docker image build -t alxinsh/metrics-demo:v2 .
docker push alxinsh/metrics-demo:v2
```

Deploy service into K8s
```bash
kubectl apply -f ./k8s/
```

### Cleanup K8s
```bash
kubectl delete -f ./k8s/ 
```

### Application load test
Doesn't work:
```bash
minikube service metrics-demo
```

Variant 1: Enable tunnel
```bash
minikube tunnel
```

Get external application IP:
```bash

kubectl get service metrics-demo
NAME           TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)    AGE
metrics-demo   ClusterIP   10.104.249.93   <none>        8090/TCP   4h51m
```

Variant 2: Forward Application port to host PC:
```bash
kubectl port-forward service/metrics-demo  8090
```

Test service endpoint:
```bash
curl localhost:8090/actuator
```

Forward Prometheus port to host PC:
```bash
kubectl port-forward service/prometheus-operated  9090
```

Open in Browser Prometheus Web UI:  
127.0.0.1:9090

Hit menu: Status > Targets  
Will be show 2 Pods

For testing install Apache ab software:
```bash
sudo apt-get install apache2-utils
```

Runs load test for application:
```bash
ab -n 500 -c 50 http://localhost:8090/api/a
ab -n 500 -c 50 http://localhost:8090/api/b

ab -n 500 -c 50 http://localhost:8090/api/error-code
```

Hit menu: Graph  
Запрос из БД Prometheus на текущее время. PromQL

Запрос 1 по метрики:  
http_server_requests_seconds_count

Запрос 2 по метрики и тегу uri:  
http_server_requests_seconds_count{uri="/api/a"}

График этой метрике

### Grafana
Setup port forwarding:
```bash
kubectl port-forward service/stack-grafana  9000:80
```

Open in Browser: 127.0.0.1:9000  
admin/prom-operator

