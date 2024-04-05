package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
		
		//mock do save e update
		Venda venda = new Venda(1, "endereco", 250, "CONFIRMADO", null, null, null);
		when(this.vendaRepository.save(Mockito.any())).thenReturn(venda);
		
		//mock do delete
		doNothing().when(this.vendaRepository).deleteById(Mockito.anyLong());
		
		//mock do findall
		List<Venda> lista = new ArrayList<>();
		lista.add(new Venda(1, "endereco", 78.50, "CONFIRMADO", null, null, null));
		lista.add(new Venda(2, "endereco2", 72.50, "CONFIRMADO", null, null, null));
		when(this.vendaRepository.findAll()).thenReturn(lista);
		
		//mock do findById
		Venda venda1 = new Venda(1, "endereco", 250, "CONFIRMADO", null, null, null);
		when(this.vendaRepository.findById(Mockito.any())).thenReturn(Mockito.any());
		
		//mock do findByEndereco
		List<Venda> lista1 = new ArrayList<>();
		lista1.add(new Venda(1, "endereco", 78.50, "CONFIRMADO", null, null, null));
		when(this.vendaRepository.findByEndereco("endereco")).thenReturn(lista1);
		
		//mock do findByValor
		List<Venda> lista2 = new ArrayList<>();
		lista2.add(new Venda(1, "endereco", 78.50, "CONFIRMADO", null, null, null));
		when(this.vendaRepository.findByValor(78.50)).thenReturn(lista2);
		
		//mock do finByValorMaior
		List<Venda> lista3 = new ArrayList<>();
		lista3.add(new Venda(1, "endereco", 78.50, "CONFIRMADO", null, null, null));
		when(this.vendaRepository.findValorMaior(78.50)).thenReturn(lista3);
		
		//mock do findByValorMenor
		List<Venda> lista4 = new ArrayList<>();
		lista4.add(new Venda(1, "endereco", 78.50, "CONFIRMADO", null, null, null));
		when(this.vendaRepository.findValorMenor(78.50)).thenReturn(lista4);
		
	}
	
	
	
	//--------------------------------------------------------------------------	
	
	@Test
	@DisplayName("Teste de integração para o método findAll com mockito")
	void testeFindAll() {
		
		ResponseEntity<List<Venda>> response = this.vendaController.findAll();
		List<Venda> lista = response.getBody();
		
		assertEquals(2, lista.size());
		
	}
	
//--------------------------------------------------------------------------	
	/*@Test
	@DisplayName("Teste de integração para o método findById com mockito")
	void testeFindById() {
		ResponseEntity<Venda> response = this.vendaController.findById(1);
		
		assertTrue(response.getStatusCode() == HttpStatus.OK);
	}*/
	
	@Test
	@DisplayName("FindByIdErro")
	void testeFindByIdErro() {
		long test = -20;
		ResponseEntity<Venda> teste = this.vendaController.findById(test);
		assertTrue(teste.getStatusCode() == HttpStatus.BAD_REQUEST);
	}
	
//--------------------------------------------------------------------------	
	@Test
	@DisplayName("Save")
	void testeSave() {
		Venda test = new Venda();
		ResponseEntity<String>teste = vendaController.save(test);
		assertTrue(teste.getStatusCode() == HttpStatus.OK);
	}
	
	@Test
	@DisplayName("SaveErro")
	void testeSaveErro() {
		Venda test = null;
		ResponseEntity<String>teste = vendaController.save(test);
		assertTrue(teste.getStatusCode() == HttpStatus.BAD_REQUEST);
		
	}
	
//--------------------------------------------------------------------------	
	@Test
	@DisplayName("Update")
	void testeUpdate() {
		Venda update = new Venda(1, "endereco", 250, "CONFIRMADO", null, null, null);
		ResponseEntity<String> venda = vendaController.update(update, 0);
		assertEquals(HttpStatus.ACCEPTED, venda.getStatusCode());
	}
	
	@Test
	@DisplayName("UpdateErro")
	void testeUpdateErro() {
		Venda update = null;
		ResponseEntity<String> venda = vendaController.update(update, 0);
		assertEquals(HttpStatus.BAD_REQUEST, venda.getStatusCode());

	}
	
	//--------------------------------------------------------------------------
	@Test
	@DisplayName("Delete")
	void testeDelete() {
		ResponseEntity<String> venda = vendaController.delete(1);
		assertEquals(HttpStatus.OK, venda.getStatusCode());
	}
	
	@Test
	@DisplayName("DeleteErro")
	void testeDeleteErro() {
		ResponseEntity<String> venda = vendaController.delete(1);
		assertEquals(HttpStatus.BAD_REQUEST, venda.getStatusCode());

	}
	
	//--------------------------------------------------------------------------
	@Test
	@DisplayName("endereco")
	void testeEndereco() {
		ResponseEntity<List<Venda>> response = this.vendaController.findByEndereco("endereco");
		List<Venda> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
	
	//--------------------------------------------------------------------------	
	@Test
	@DisplayName("valor")
	void testeValor() {
		ResponseEntity<List<Venda>> response = this.vendaController.findByValor(78.50);
		List<Venda> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
	
	//--------------------------------------------------------------------------
	@Test
	@DisplayName("valorMaior")
	void testeValorMaior() {
		ResponseEntity<List<Venda>> response = this.vendaController.findValorMaior(78.50);
		List<Venda> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
	
	//--------------------------------------------------------------------------
	@Test
	@DisplayName("valorMenor")
	void testeValorMenor() {
		ResponseEntity<List<Venda>> response = this.vendaController.findValorMenor(78.50);
		List<Venda> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
	
}
