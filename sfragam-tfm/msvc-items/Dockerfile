ARG MSVC_NAME=msvc-items
FROM openjdk:18-jdk-alpine as mavenBuilder
ARG MSVC_NAME

WORKDIR /app/$MSVC_NAME

COPY ./pom.xml /app
COPY ./$MSVC_NAME/.mvn ./.mvn
COPY ./$MSVC_NAME/mvnw .
COPY ./$MSVC_NAME/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./$MSVC_NAME/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:18-jdk-alpine
ARG MSVC_NAME
WORKDIR /app
RUN mkdir ./logs
COPY --from=mavenBuilder /app/$MSVC_NAME/target/msvc-items-0.0.1-SNAPSHOT.jar .

EXPOSE 8001
CMD ["java", "-jar", "./msvc-items-0.0.1-SNAPSHOT.jar"]
