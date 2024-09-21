FROM openjdk:17
EXPOSE 8081
ADD target/pagination_backend.jar pagination_backend.jar
ENTRYPOINT ["java","-jar","/pagination_backend.jar"]