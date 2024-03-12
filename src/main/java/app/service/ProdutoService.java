package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.repository.ProdutoRepository;


@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public String save (Produto produto) {
		
		this.produtoRepository.save(produto);
		return "Produto salvo com sucesso!";
	}
	
	public String update (Produto produto, long id) {
		
		produto.setId(id);
		this.produtoRepository.save(produto);
		return "Produto atualizado com sucesso!";
	}
	
	public String delete (long id) {
		
		this.produtoRepository.deleteById(id);
		return "produto deletado com sucesso!";
	}
	
	public List<Produto> findAll() {
		 List<Produto> lista = this.produtoRepository.findAll();
		return lista;
	}
	
	public Produto findById(long id) {
		 Produto produto = this.produtoRepository.findById(id).get();
		return produto;
	}
	
	public List<Produto> findByNome(String nome) {
	        return produtoRepository.findByNome(nome);
	 }

	    public List<Produto> findByValor(double valor) {
	        return produtoRepository.findByValor(valor);
	    }

	    public List<Produto> findByValorMaior(double valor) {
	        return produtoRepository.findByValorMaior(valor);
	    }

	    public List<Produto> findByValorMenor(double valor) {
	        return produtoRepository.findByValorMenor(valor);
	    }


}
