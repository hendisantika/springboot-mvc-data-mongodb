FROM java:8
MAINTAINER hendisantika@yahoo.co.id
VOLUME /tmp
ADD build/libs/springboot-mvc-data-mongodb-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
