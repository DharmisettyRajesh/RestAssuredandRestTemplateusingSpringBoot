FROM openjdk:8
EXPOSE 8080
ADD target/spring-docker-by-rajesh17523.jar spring-docker-by-rajesh17523.jar
ENTRYPOINT ["java","-jar","/spring-docker-by-rajesh17523.jar"]