package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	
	@Query("SELECT c FROM Cliente c WHERE c.nome LIKE CONCAT ('%', :nome, '%')")
	public List<Cliente> findByNome (String nome);
	
	public List<Cliente> findByCpf (String cpf);
	
	public List<Cliente> findByIdade (int idade);
	
	public List<Cliente> findByTelefone (String telefone);

}
