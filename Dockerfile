FROM alpine:3 as base

RUN apk add --no-cache protoc git protobuf-dev

WORKDIR /googleapis
RUN git clone --depth 1 https://github.com/googleapis/googleapis

WORKDIR /app
COPY /envoy/envoy.yaml .
COPY src/main/proto/service.proto .
RUN  protoc -I/googleapis/googleapis/ -I. --include_imports --include_source_info  --descriptor_set_out=/app/service.pb service.proto

FROM envoyproxy/envoy:v1.18.3
COPY --from=base /app/service.pb /home/envoy/service.pb
COPY --from=base /app/envoy.yaml /home/envoy/envoy.yaml
EXPOSE 9901 51051

CMD /usr/local/bin/envoy -c /home/envoy/envoy.yaml