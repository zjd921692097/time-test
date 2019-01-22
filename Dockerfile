FROM huanwei/alpine-java:8
VOLUME /tmp
ADD target/min-test-0.0.1-SNAPSHOT.jar app.jar