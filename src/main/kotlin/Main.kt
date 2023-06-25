import com.knitehias.grpc.strlen.LenServer

fun main(args: Array<String>) {
    val port = System.getenv("PORT")?.toInt() ?: 50051
    val server = LenServer(port)
    server.start()
    server.blockUntilShutdown()
}
