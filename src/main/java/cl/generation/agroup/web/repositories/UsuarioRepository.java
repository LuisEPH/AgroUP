package cl.generation.agroup.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.generation.agroup.web.models.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	//Esta es la lógica de progra.

}
