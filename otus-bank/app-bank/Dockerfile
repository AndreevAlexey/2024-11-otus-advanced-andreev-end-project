FROM bellsoft/liberica-openjdk-alpine-musl:21.0.1
COPY ./target/app-bank-0.0.1-SNAPSHOT.jar /app/app-bank.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app-bank.jar"]