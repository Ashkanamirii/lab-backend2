FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=target/*.jar

WORKDIR /myJavaDir

COPY ${JAR_FILE} bank-app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","bank-app.jar"]