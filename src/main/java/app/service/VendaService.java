package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Venda;
import app.repository.VendaRepository;

@Service

public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public String save (Venda venda) {
		
		this.vendaRepository.save(venda);
		return "Venda salvo com sucesso!";
	}
	
	public String update (Venda venda, long id) {
		
		venda.setId(id);
		this.vendaRepository.save(venda);
		return "Venda atualizado com sucesso!";
	}
	
	public String delete (long id) {
		
		this.vendaRepository.deleteById(id);
		return "Venda deletado com sucesso!";
	}
	
	public List<Venda> findAll() {
		 List<Venda> lista = this.vendaRepository.findAll();
		return lista;
	}
	
	public Venda findById(long id) {
		 Venda venda = this.vendaRepository.findById(id).get();
		return venda;
	}

}
