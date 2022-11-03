package mx.uv.c80688;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        get("/aaron", (req, res) -> "Hello Aaron");
        get("/omar", (req, res) -> "Hello Omar");
        get("/eduardo", (req, res) -> "Hello Eduardo");
        get("/", (req, res) -> "<h1>Hola Sistemas Web</h1>");
        post("/", (req,res)->{
            System.out.println("login: " + req.queryParams("login"));
            System.out.println("contraseña" + req.queryParams("contraseña"));
            res.status(200);
            return null;
            
        });
    }
}
