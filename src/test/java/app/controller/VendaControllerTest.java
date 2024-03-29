package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import app.entity.Venda;
import app.repository.VendaRepository;

@SpringBootTest
public class VendaControllerTest {
	
	@Autowired
	VendaController vendaController;
	
	@MockBean
	VendaRepository vendaRepository;
	
	//Venda venda = new Venda(0, "endereco", 600, "CANCELADO", null, null, null);
	@BeforeEach
	void setup() {
		
		//save
		//Venda venda = new Venda(1, "endereco", 78.50, "CONFIRMADO", null, null, null);
		//when(this.vendaRepository.save(venda)).thenReturn(venda);
		//findAll
		List<Venda> lista = new ArrayList<>();
		lista.add(new Venda(1, "endereco", 78.50, "CONFIRMADO", null, null, null));
		lista.add(new Venda(2, "endereco2", 72.50, "CONFIRMADO", null, null, null));
		when(this.vendaRepository.findAll()).thenReturn(lista);
		//findById
		//when(this.vendaRepository.findById(1)).thenReturn();
		
		
	}
	
	/*@Test
	@DisplayName("Teste de integração para o método save com mockito")
	void testeSave() {
		
		Venda venda = new Venda(1, "endereco", 78.50, "CONFIRMADO", null, null, null);
		ResponseEntity<Venda> response = this.vendaController.save(venda);
		
		assertEquals(2, lista.size());
		
	}*/
	
	@Test
	@DisplayName("Teste de integração para o método findAll com mockito")
	void testeFindAll() {
		
		ResponseEntity<List<Venda>> response = this.vendaController.findAll();
		List<Venda> lista = response.getBody();
		
		assertEquals(2, lista.size());
		
	}
	
}
