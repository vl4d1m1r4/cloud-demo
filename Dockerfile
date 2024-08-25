# Build from GraalVM image
FROM container-registry.oracle.com/graalvm/native-image:22 AS build

# Prepare build dir
RUN mkdir /build
COPY . /build
WORKDIR /build

# Make mvnw executable
RUN chmod +x ./mvnw

# Run maven build command
RUN ./mvnw -Pnative -DskipTests native:compile


FROM ubuntu:jammy

COPY --from=build /build/target/cloud-demo /work/app
COPY --from=build /build/target/*.so /work/

# set up permissions for user `1001`
RUN chmod 775 /work /work/app \
  && chown -R 1001 /work \
  && chmod -R "g+rwX" /work \
  && chown -R 1001:root /work

EXPOSE 8080
USER 1001

ENTRYPOINT ["/work/app"]
