# kgrpc-envoy

A vanilla grpc servier in Kotlin and an envoy grpc-JSON/HTTP transcoder which allows a RESTful JSON API client to send requests to Envoy over HTTP and get proxied to a gRPC service

## Description

A Kotlin simple grpc server which could handle both REST and gRPC request thanks to the [grpc-json-transcoder](https://www.envoyproxy.io/docs/envoy/latest/configuration/http/http_filters/grpc_json_transcoder_filter#grpc-json-transcoder)
- maven
- docker
- kotlin
- envoy
- protoc
- googleapis

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)


## Installation

### run the server
- ```mvn clean package```  
- ```java -jar target/kgrpc-0.1.1-jar-with-dependencies.jar```
### run the envoy
- ```docker build . -t kgrpc-envoy```
- ```docker run --publish 9901:9901 --publish 51051:51051 --rm kgrpc-envoy```

## Usage

### gRPC side
```grpcurl --plaintext -d '{str: abceisaname}'  localhost:50051 com.knitehias.grpc.strlen.StrLenService/Len ```
### REST side
```curl -X GET -v -H "Content-Type: application/json" localhost:51051/v1/len/abceisaname```  


### Kotlin gRPC Server

The little Kotlin gRPC server will return the length of the inputing string.

### Envoy gRPC-JSON/HTTP Transcoder

A Kotlin simple grpc server which could handle both REST and gRPC request thanks to the [grpc-json-transcoder](https://www.envoyproxy.io/docs/envoy/latest/configuration/http/http_filters/grpc_json_transcoder_filter#grpc-json-transcoder)


### Google API

[googleapis](https://cloud.google.com/service-infrastructure/docs/service-management/reference/rpc/google.api#http)


## Trivial 

### envoy admin
- ```curl -X POST http://localhost:9901/clusters```

- ```curl -X POST http://localhost:9901/logging?connection=debug```


### Docker run network

> I want to connect from a container to a service on the host  
> The host has a changing IP address, or none if you have no network access. We recommend that you connect to the special DNS name host.docker.internal which resolves to the internal >IP address used by the host. This is for development purpose and does not work in a production environment outside of Docker Desktop.  
>You can also reach the gateway using gateway.docker.internal.