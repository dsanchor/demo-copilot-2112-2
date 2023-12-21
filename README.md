# Spring Boot Rest API demo

## Compilar

```bash
mvn clean package
```

## Ejecutar

```bash
mvn spring-boot:run
```

## Probar con curl

```bash
curl http://localhost:8080/api/hello
```

## Probar operación reverse
    
```bash
curl http://localhost:8080/api/reverse?input=hello
```

## Probar operacion removeVowels

```bash
curl http://localhost:8080/api/removeVowels?input=hello
```

## Lanzar test unitarios

```bash
mvn test
```

# Containerizar

## Crear imagen docker

```bash
docker build -t spring-boot-rest-api-demo .
```

## Ejecutar imagen docker

```bash
docker run -p 8080:8080 spring-boot-rest-api-demo
```

# Despliegue en AKS (Azure Kubernetes Service)

## Inicializar variables de entorno

```bash
export RESOURCE_GROUP=aks-demo-alb-rg
export CLUSTER_NAME=demo
export NAMESPACE=demo2112
```
## Obtener credenciales del cluster

```bash
az aks get-credentials --resource-group $RESOURCE_GROUP --name $CLUSTER_NAME
```

## Crear namespace

```bash
kubectl create namespace $NAMESPACE
```

## Desplegar aplicación

```bash
kubectl apply -f k8s/application.yaml -n $NAMESPACE
```

## Obtener IP pública del balanceador de carga

```bash
export SVC_IP=$(kubectl get service my-app-service -n $NAMESPACE -o jsonpath='{.status.loadBalancer.ingress[0].ip}')
```

## Probar aplicación

```bash
curl http://$SVC_IP/api/hello
```