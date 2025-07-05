FROM bellsoft/liberica-openjdk-alpine-musl:21.0.1
COPY ./target/app-moves-0.0.1-SNAPSHOT.jar /app/app-moves.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/app/app-moves.jar"]