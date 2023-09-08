FROM openjdk:17
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY target/SpringKubernates-0.0.1-SNAPSHOT.jar SpringKubernates-0.0.1-SNAPSHOT.jar
ENTRYPOINT exec java $JAVA_OPTS -jar SpringKubernates-0.0.1-SNAPSHOT.jar
