FROM oracle/graalvm-ce:20.2.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/page-demo
WORKDIR /home/app/page-demo

RUN native-image -cp target/page-demo-*.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/page-demo/page-demo /app/page-demo
ENTRYPOINT ["/app/page-demo"]
