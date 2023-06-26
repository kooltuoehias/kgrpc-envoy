java -jar .\target\kgrpc-0.1.1-jar-with-dependencies.jar

PS D:\go\dev\bin> .\grpcurl.exe --plaintext -d '{\"str\": \"abceisaname\"}'  localhost:50051 com.knitehias.grpc.strlen.StrLenService/Len

docker run --publish 9901:9901 --publish 51051:51051 --rm  kgrpc-envoy-4  
curl -X POST http://localhost:9901/clusters  
curl -X POST http://localhost:9901/logging?connection=debug

I want to connect from a container to a service on the host
The host has a changing IP address, or none if you have no network access. We recommend that you connect to the special DNS name host.docker.internal which resolves to the internal IP address used by the host. This is for development purpose and does not work in a production environment outside of Docker Desktop.

You can also reach the gateway using gateway.docker.internal.