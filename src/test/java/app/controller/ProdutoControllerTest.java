package app.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.entity.Produto;
import app.entity.Venda;
import app.repository.ProdutoRepository;

@SpringBootTest
public class ProdutoControllerTest {
	
	@Autowired
	ProdutoController produtoController;
	
	@MockBean
	ProdutoRepository produtoRepository;
	
	@BeforeEach
	void setup() {
		
		//mock do save e update
		Produto produto = new Produto(1, "NOME", 400);
		when(this.produtoRepository.save(Mockito.any())).thenReturn(produto);
		
		//mock do delete
		doNothing().when(this.produtoRepository).deleteById(Mockito.anyLong());
		
		//mock do findall
		List<Produto> lista = new ArrayList<>();
		lista.add(new Produto(1, "nome", 72.50));
		lista.add(new Produto(2, "nome2", 71.50));
		when(this.produtoRepository.findAll()).thenReturn(lista);
		
		//mock do findById
		Produto produto1 = new Produto(1, "nome", 450);
		when(this.produtoRepository.findById(Mockito.any())).thenReturn(Mockito.any());
		
		//mock do findByNome
		List<Produto> lista1 = new ArrayList<>();
		lista.add(new Produto(1, "nome", 68.50));
		when(this.produtoRepository.findByNome("nome")).thenReturn(lista1);
		
		//mock do findByValor
		List<Produto> lista2 = new ArrayList<>();
		lista2.add(new Produto(1, "nome", 68.50));
		when(this.produtoRepository.findByValor(68.50)).thenReturn(lista2);
				
		//mock do finByValorMaior
		List<Produto> lista3 = new ArrayList<>();
		lista3.add(new Produto(1, "nome", 68.50));
		when(this.produtoRepository.findByValorMaior(68.50)).thenReturn(lista3);
				
		//mock do findByValorMenor
		List<Produto> lista4 = new ArrayList<>();
		lista4.add(new Produto(1, "nome", 68.50));
		when(this.produtoRepository.findByValorMenor(78.50)).thenReturn(lista4);
		
	}
	
	//--------------------------------------------------------------------------	
		@Test
		@DisplayName("Save")
		void testeSave() {
			Produto test = new Produto();
			ResponseEntity<String>teste = produtoController.save(test);
			assertTrue(teste.getStatusCode() == HttpStatus.OK);
		}
		
		@Test
		@DisplayName("SaveErro")
		void testeSaveErro() {
			Produto test = null;
			ResponseEntity<String>teste = produtoController.save(test);
			assertTrue(teste.getStatusCode() == HttpStatus.BAD_REQUEST);
			
		}
		
	//--------------------------------------------------------------------------

}
