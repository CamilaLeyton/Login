package com.codingdojo.camila.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.camila.modelos.User;

@Repository
public interface RepositorioUsuarios extends CrudRepository<User, Long>{
	
	User findByEmail(String email); //SELECT * FROM usuarios WHERE email =<email>;

}
