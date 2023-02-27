package es.codeurjc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	public String Admin(Model model) {


		return "Pantalla-Administracion";
	}
}
