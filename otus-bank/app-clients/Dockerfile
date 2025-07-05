FROM bellsoft/liberica-openjdk-alpine-musl:21.0.1
COPY ./target/app-clients-0.0.1-SNAPSHOT.jar /app/app-clients.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/app-clients.jar"]