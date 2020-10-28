FROM java:8
EXPOSE 8080
COPY /retail-menagement-service.jar retail-menagement-service.jar
ENTRYPOINT ["java","-jar","retail-menagement-service.jar"]