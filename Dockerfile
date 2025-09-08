FROM openjdk:21-jdk-slim
WORKDIR /offsideAi
COPY target/offsideAi-0.0.1-SNAPSHOT.jar offsideAi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "offsideAi.jar"]

