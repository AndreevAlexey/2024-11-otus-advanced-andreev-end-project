FROM bellsoft/liberica-openjdk-alpine-musl:21.0.1
COPY ./target/app-gateway-0.0.1-SNAPSHOT.jar /app/app-gateway.jar
COPY ./application-docker.yml /app/application.yml
EXPOSE 8888
ENTRYPOINT ["java", "-Dspring.config.location=/app/application.yml", "-jar", "/app/app-gateway.jar"]