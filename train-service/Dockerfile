FROM openjdk:17-jdk-slim
ARG JAR_FILE
ENV JAVA_OPTS=""
ADD ${JAR_FILE} /home/app.jar
WORKDIR /home/
CMD java -jar $JAVA_OPTS app.jar