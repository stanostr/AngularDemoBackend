FROM openjdk:8
EXPOSE 9090
COPY target/legendary-store-app-0.0.1-SNAPSHOT.jar legendary-store-app.jar
ENTRYPOINT ["java","-jar","legendary-store-app.jar"]
