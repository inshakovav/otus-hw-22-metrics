# Spring Boot REST-service
The Spring Boot service expose CRUD to the user.  
The database credentials are specified in ENV.  
ENV are specified in secret.yaml

### Test requests
Actuator:
curl localhost:8080/actuator | json_pp

Get metrics:
curl http://localhost:8080/actuator/prometheus
