FROM azul/zulu-openjdk:17-latest
ARG JAR_FILE=build/libs/spring-boot-lecture-1.0.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]