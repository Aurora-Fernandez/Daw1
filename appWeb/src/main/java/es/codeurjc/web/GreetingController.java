package es.codeurjc.web;

import java.util.Collection;


import java.sql.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
// import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.codeurjc.web.Book;
import es.codeurjc.web.services.BookService;

@Controller
// esta clase esta para gestionar los cambios de pagina 
/*
 Esto funciona porque ya no llamas a html estatico sino que haces peticiones http  
 Tipo get pagina foro
 y para que funcione se utiliza los controladores de get mapping
 Entonces el elemento del html en su href tine por ejemplo "/Pantalla-Perfil" y luego nuestra app
 Llama @GetMapping("/Pantalla-Perfil") para que haga return de su html (que este en el controlador
 se escribe sin .html)
 */
public class GreetingController {

	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String bbdd="jdbc:mysql://localhost:8442/bee";
	private static final String usuario ="root";
	private static final String clave="password"; 


	/* Creamos el método para conectarnos a la base de datos. Este método
    devolverá un objeto de tipo Connection.*/
public static Connection Conexion(){
    /*Declaramos una variable para almacenar la cadena de conexión.
    Primero la iniciamos en null.*/
    Connection conex = null;
         
    //Controlamos la excepciones que puedan surgir al conectarnos a la BBDD
    try {

		/* String connectionUrl =
		"jdbc:mysql://yourserver.database.windows.net:8443;"
				+ "database=bee;"
				+ "user=root@localhost;"
				+ "password=password;"
				; */
        //Registrar el driver
        Class.forName(driver);
        //Creamos una conexión a la Base de Datos
        conex = DriverManager.getConnection(bbdd, usuario, clave);
		//conex = DriverManager.getConnection(connectionUrl);
         
    // Si hay errores informamos al usuario. 
    } catch (Exception e) {
        System.out.println("Error al conectar con la base de datos.\n"
                + e.getMessage().toString());
    }
    // Devolvemos la conexión.
    return conex;
}


	@Autowired
	private BookService bookService;


	@GetMapping("/")
	public String Principal(Model model) {

		Connection conex=null;

		conex = Conexion();
 
		// Si la variable objeto conex es diferente de nulo
		if(conex != null){
			// Informamos que la conexión es correcta
			System.out.println("Conectado correctamente");
		}else{ // Sino informamos que no nos podemos conectar.
			System.out.println("No has podido conectarte");
		}
		return "Pantalla-Principal";
	}


	@GetMapping("/Pantalla-Buscador-Categorias")
	public String Buscador(Model model) {


		return "Pantalla-Buscador-Categorias";
	}



	@GetMapping("/Pantalla-Foro")
	public String Foro(Model model) {


		return "Pantalla-Foro";
	}


	@GetMapping("/Pantalla-Registro")
	public String Registro(Model model) {


		return "Pantalla-Registro";
	}


	@GetMapping("/Pantalla-Perfil")
	public String Perfil(Model model) {


		return "Pantalla-Perfil";
	}



	@GetMapping("/Pantalla-InicioSesion")
	public String InicioSesion(Model model) {


		return "Pantalla-InicioSesion";
	}

	@GetMapping("/Pantalla-Administracion")
	public String Admin(Model model, Pageable pageable) {

		Collection<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		return "Pantalla-Administracion";
	}



	// para cuando se elija un libro que lee se ha cargado de la base de datos
	@GetMapping("/book/{id}")
	public String showPost(Model model, @PathVariable long id) {

		Book book = bookService.findById(id).orElseThrow();

		model.addAttribute("book", book);

		return "show_post";
	}
}
