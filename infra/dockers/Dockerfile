
FROM maven:3.9.5-eclipse-temurin-21-alpine AS build

WORKDIR /app


COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn package -DskipTests

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

EXPOSE 8080

ARG JAR_FILE=target/*.jar
COPY --from=build /app/${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
