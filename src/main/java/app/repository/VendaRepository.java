package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

	public List<Venda> findByEndereco (String enderecoDaEntrega);
	
	public List<Venda> findByValor (double valor);
	
	@Query("FROM Venda v WHERE v.valor > :valor")
	public List<Venda> findValorMaior (double valor);
	
	@Query("FROM Venda v WHERE v.valor < :valor")
	public List<Venda> findValorMenor (double valor);
	
}
