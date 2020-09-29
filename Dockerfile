FROM java:8
EXPOSE 8080
ADD /target/neo4j-spring-boot.jar neo4j-spring-boot.jar
ENTRYPOINT ["java", "-jar", "neo4j-spring-boot.jar"]

