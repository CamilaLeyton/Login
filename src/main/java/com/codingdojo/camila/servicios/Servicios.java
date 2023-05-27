package com.codingdojo.camila.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.camila.modelos.User;
import com.codingdojo.camila.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	
	@Autowired 
	private RepositorioUsuarios repoUsuarios;
	
	public User registrar(User nuevoUsuario, BindingResult result) {
		//REVISAMOS QUE EL CORREO QUE RECIBIMOS NO EXISTA EN NUESTRA TABLA DE USUARIOS
		String email = nuevoUsuario.getEmail();
		User existeUsuario = repoUsuarios.findByEmail(email); //NULL O OBEJTO DE USUARIO
		if(existeUsuario != null) {
			//EL CORREO YA ESTA REGISTRADO
			result.rejectValue("email", "Unique", "El correo ya está en uso");
		}
		
		//COMPARAMOS CONTRASEÑAS
		String contrasena = nuevoUsuario.getContrasena();
		String confirmacion = nuevoUsuario.getConfirmacion();
		if(!contrasena.equals(confirmacion)) {
			result.rejectValue("confirmacion", "Matches", "Las contraseñas no coinciden");
		}
		
		//SI NO EXISTE ERROR, GUARDAMOS!
		if(result.hasErrors()) {
			return null;
		} else {
			//ENCRIPTAMOS CONTRASEÑA
			String contra_encriptada = BCrypt.hashpw(nuevoUsuario.getContrasena(), BCrypt.gensalt());
			nuevoUsuario.setContrasena(contra_encriptada);
			return repoUsuarios.save(nuevoUsuario);
		}
	}
	
		public User login(String email, String password) {
		
			//Buscar que el correo recibido esté en BD
			User existeUsuario = repoUsuarios.findByEmail(email); //NULL o Objeto de Usuario
			if(existeUsuario == null) {
				return null;
			}
			//Comparamos contraseñas
			//BCrypt.checkpw(Contraseña NO encriptada, Contraseña encriptada) -> True o False
			if(BCrypt.checkpw(password, existeUsuario.getContrasena())) {
				return existeUsuario;
			} else {
				return null;
			}
	}
}
