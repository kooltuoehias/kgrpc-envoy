mvn compile exec:java -Dexec.mainClass="MainKt"  
java -jar .\target\kgrpc-0.1.1-jar-with-dependencies.jar

PS D:\go\dev\bin> .\grpcurl.exe --plaintext -d '{\"str\": \"abceisaname\"}'  localhost:50051 com.knitehias.grpc.strlen.StrLenService/Len