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

