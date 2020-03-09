FROM maven:3.0.5 AS MAVEN_BUILD
MAINTAINER Amol Aherkar
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package
FROM java:8
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/ThymedemoCRUD-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "ThymedemoCRUD-0.0.1-SNAPSHOT.jar"]
EXPOSE 8089