## Multi-stage Dockerfile with dev and prod targets

# ---------- Base (cache deps)
FROM maven:3.9.5-eclipse-temurin-21-alpine AS base
WORKDIR /app
COPY pom.xml .
RUN mvn -q -B dependency:go-offline

# ---------- Build (package jar)
FROM base AS build
COPY src ./src
RUN mvn -q -B package -DskipTests

# ---------- Production runtime
FROM eclipse-temurin:21-jre-alpine AS prod
WORKDIR /app
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY --from=build /app/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
