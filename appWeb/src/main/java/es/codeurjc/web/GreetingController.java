package es.codeurjc.web;

import java.util.Collection;

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

	@Autowired
	private BookService bookService;


	@GetMapping("/")
	public String Principal(Model model) {


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
