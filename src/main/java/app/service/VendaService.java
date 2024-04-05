package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.entity.Venda;
import app.repository.VendaRepository;

@Service

public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public String save (Venda venda) {
		
		if (venda == null)
			throw new RuntimeException("Objeto não pode estar nulo");
		
		double valorTotal = this.calcularValorTotal(venda.getProdutos());
		venda.setValor(valorTotal);
		this.vendaRepository.save(venda);
		return "Venda salvo com sucesso!";
	}
	
	public String update (Venda venda, long id) {
		
		if (venda == null)
			throw new RuntimeException("Objeto não pode estar nulo");
		
		venda.setId(id);
		double valorTotal = this.calcularValorTotal(venda.getProdutos());
		venda.setValor(valorTotal);
		venda = this.verificarStatus(venda);
		this.vendaRepository.save(venda);
		return "Venda atualizado com sucesso!";
	}
	
	public String delete (long id) {
		
		if(id < 0)
			throw new RuntimeException("Objeto não pode estar nulo");
		
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
	
	public List<Venda> findByEndereco(String enderecoDaEntrega) {
        return vendaRepository.findByEndereco(enderecoDaEntrega);
    }

    public List<Venda> findByValor(double valor) {
        return vendaRepository.findByValor(valor);
    }

    public List<Venda> findValorMaior(double valor) {
        return vendaRepository.findValorMaior(valor);
    }

    public List<Venda> findValorMenor(double valor) {
        return vendaRepository.findValorMenor(valor);
    }
    
    //-----------------------------------------------------
    
    public double calcularValorTotal(List<Produto> produtos) {
    	double soma = 0;
    	if(produtos != null) {
    		for(int i = 0; i < produtos.size(); i++) {
    			soma += produtos.get(i).getValor();
    		}
    	}
    	return soma;
    }
    
    public Venda verificarStatus(Venda venda) {
    	if(venda.getStatus().equals("CANCELADO")) {
    		venda.setValor(0);
    		venda.setProdutos(null);
    	}
    	return venda;
    }

}
