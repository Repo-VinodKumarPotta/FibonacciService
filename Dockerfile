FROM openjdk:8
ADD target/FibonacciService-1.0-SNAPSHOT.jar FibonacciService-1.0-SNAPSHOT.jar
ADD hello-world.yml hello-world.yml
EXPOSE 8080
ENTRYPOINT ["java","-jar","FibonacciService-1.0-SNAPSHOT.jar"]
