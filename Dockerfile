FROM anapsix/alpine-java:latest
ADD target/basic-service-0.0.1.jar /usr/app/app.jar
ENTRYPOINT ["java", "-jar", "/usr/app/app.jar"]