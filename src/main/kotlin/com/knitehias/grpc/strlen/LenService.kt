package com.knitehias.grpc.strlen

import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.protobuf.services.ProtoReflectionService

class LenService : StrLenServiceGrpcKt.StrLenServiceCoroutineImplBase() {
    override suspend fun len(request: StrRequest): StrReply {
        println(request.str)
        return strReply { len = request.str.length }
    }
}

class LenServer(private val port: Int) {
    private val server: Server = ServerBuilder
        .forPort(port)
        .addService(LenService())
        .addService(ProtoReflectionService.newInstance())
        .build()

    fun start() {
        server.start()
        println("Server started, listening on $port")
        Runtime.getRuntime().addShutdownHook(
            Thread {
                println("*** shutting down gRPC server since JVM is shutting down")
                stop()
                println("*** server shut down")
            },
        )
    }

    private fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }
}
