import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import akka.http.scaladsl.model.ContentTypes
import akka.http.scaladsl.model.HttpEntity
import org.json4s._
import org.json4s.jackson.JsonMethods._

object MyAPI {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    val miApiRoute: Route = path("mi_api") {
      post {
        entity(as[String]) { jsonStr =>
          // Procesar el JSON recibido como un String
          // Aquí puedes usar alguna librería como "json4s" para convertir el String en un objeto JSON
          // Por ejemplo:
          import org.json4s._
          import org.json4s.jackson.JsonMethods._
          val json = parse(jsonStr)

          // Devolver una respuesta
          complete("Hola desde la API!: POST recibido. JSON recibido: " + jsonStr)
        }
      } ~
        get {
          entity(as[String]) { jsonStr =>
            // Procesar el JSON recibido como un String
            // Aquí puedes usar alguna librería como "json4s" para convertir el String en un objeto JSON
            // Por ejemplo:
            import org.json4s._
            import org.json4s.jackson.JsonMethods._
            val json = parse(jsonStr)

            // Devolver una respuesta
            complete("Hola desde la API!: GET recibido. JSON recibido: " + jsonStr)
          }
        }

    }

    val bindingFuture = Http().bindAndHandle(miApiRoute, "localhost", 8080)

    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    scala.io.StdIn.readLine()

    bindingFuture.flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}
