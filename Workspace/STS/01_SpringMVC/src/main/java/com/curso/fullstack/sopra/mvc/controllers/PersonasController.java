package com.curso.fullstack.sopra.mvc.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.curso.fullstack.sopra.mvc.dto.Persona;

@Controller
public class PersonasController {

	// http://localhost:8080/persona/saludo/juan?prefix=Hola
	@GetMapping(path = "/persona/saludo/{briam}--{apellido}")
	// si solo hay un path variable, no hace falta poner esto
	// @PathVariable("briam"), vale con poner @PathVariable() String briam
	// Los parametros ?prfix=Hola en la url se recogen con @RequestParam("prefix")
	// String prefijo, si solo hay uno pasa lo mismo que con @PathVariable
	public String saludo(@PathVariable(name="briam", required=false) String nombre, @PathVariable(name="apellido", required=false) String apellido,
			@RequestParam(name="prefix", required=false, defaultValue="World") String prefijo, Model model) {// El model se crea en el dispacher Server Spring y se
																	// envia como argumento (ciomo un puntero ) y el
																	// controlador lo rellena, asi no hace falta hacer
																	// un return de un model
		model.addAttribute("dato", "Hola"+nombre+"  "+apellido+" Con Prefijo: " +prefijo);// model se envia al otro
																							// lado como setAttribute
																							// con los servlets, se
																							// podria poner httpserver
																							// request
		return "exito";// la etiqueta exito es la que se va a utilizar en la vista, con thymeleaf
	}

	// Son diferentes metodos get gracias a la ruta,url
	@GetMapping(path = "/persona/saludo")
	public String saludo2(Model model) {
		model.addAttribute("dato", "Esto es un objetop string que hereda del tipo objeto");// model se envia al otro
		return "exito";

	}

	// Podemos recibir datos por el body de una peticion POST, necesitamos un
	// formulario HTML
	// Vamos a devolver un modelandview, necesitamos crear un modelo, para eso
	// utilizamos un mapeo
	@PostMapping(path = "/persona/saludo")
	public ModelAndView saludo3(@RequestBody Persona persona) {
		Map<String, Object> model = new HashMap<>();// Se pone Object para poder enviar cualquier tipo de objeto con una
													// etiqueta como con setAttribute
		model.put("dato", "Esto es un objetop string que hereda del tipo objeto");
		model.put("persona", persona);

		return new ModelAndView("exito", model);

	}

}
