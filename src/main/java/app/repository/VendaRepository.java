package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

	public List<Venda> findByEnderecoDaEntrega (String enderecoDaEntrega);
	
	public List<Venda> findByValorTotal (double valor);
	
}
