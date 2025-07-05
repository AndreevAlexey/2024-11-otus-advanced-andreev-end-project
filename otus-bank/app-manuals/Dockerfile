FROM bellsoft/liberica-openjdk-alpine-musl:21.0.1
COPY ./target/app-manuals-0.0.1-SNAPSHOT.jar /app/app-manuals.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "/app/app-manuals.jar"]