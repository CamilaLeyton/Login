package com.codingdojo.camila.controladores;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.camila.modelos.User;
import com.codingdojo.camila.servicios.Servicios;

@Controller
 class ControladorUsuarios {
	
	@Autowired 
	private Servicios servicio;
	
	@GetMapping("/")
	public String index(@ModelAttribute("nuevoUsuario") User nuevoUsuario) {
		return "index.jsp";
	}
	
	@PostMapping("registro")
	public String registro(@Valid @ModelAttribute("nuevoUsuario") User nuevoUsuario,
							BindingResult result,
							HttpSession session) {
		
		//METODO EN SERVICIO
		servicio.registrar(nuevoUsuario, result);
		
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			//GUARDAR SESION
			session.setAttribute("usuarioEnSesion", nuevoUsuario);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/dashboard")
	public String dashboard (HttpSession session) {
		
		User usuarioEnMetodo = (User)session.getAttribute("usuarioEnSesion");
		
		if(usuarioEnMetodo == null) {
			return "redirect:/";
		}
		return "dashboard.jsp";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email,
						@RequestParam("contrasena") String contrasena,
						RedirectAttributes redirectAttributes,
						HttpSession session) {
		
		//enviar email y contraseña y que el servicio verifique si son correctos
				User usuarioLogin = servicio.login(email, contrasena);
				
				if(usuarioLogin == null) {
					//Hay error
					//redirectAttributes.addFlashAttribute("error_login", "El correo/password es incorrecto");
					redirectAttributes.addFlashAttribute("error_login", "El correo/password es incorrecto");
					return "redirect:/";
				} else {
					//Guardamos en sesion
					session.setAttribute("usuarioEnSesion", usuarioLogin);
					return "redirect:/dashboard";
				}
				
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("usuarioEnSesion");
		return "redirect:/";
	}
	
}
