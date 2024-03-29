package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.entity.Produto;
import app.entity.Venda;

@SpringBootTest
public class VendaServiceTest {
	
	@Autowired
	VendaService vendaService;
	
	@Test
	@DisplayName("TESTE UNITÁRIO DE CALCULAR VALOR TOTAL")
	void testarCalcularValorTotal() {
		
		List<Produto> lista = new ArrayList<>();
		lista.add(new Produto(1, "nome", 44.50));
		lista.add(new Produto(2, "nome2", 56.70));
		
		double total = this.vendaService.calcularValorTotal(lista);
		
		assertEquals(101.20, total);
		
	}
	
	@Test
	@DisplayName("TESTE UNITÁRIO DE EXCEÇÃO/ERRO")
	void testarCalcularValorTotal2() {
		
		List<Produto> lista = new ArrayList<>();
		lista.add(null);
		lista.add(new Produto(3, "nome3", 59.90));
		
		assertThrows(Exception.class, () -> {
			double retorno = this.vendaService.calcularValorTotal(lista);
		});
		
	}
	
	@Test
	@DisplayName("Teste para verificar status da venda, cancelado")
	void testeVerificarStatus(){
		Venda venda = new Venda(0, "endereco", 600, "CANCELADO", null, null, null);
		Venda retorno = this.vendaService.verificarStatus(venda);
		assertEquals(0, retorno.getValor());
	}
	
	@Test
	@DisplayName("Teste para verificar status da venda, exceção")
	void testeVerificarStatus2(){
		Venda venda = new Venda(0, "endereco", 600, null, null, null, null);
		
		assertThrows(Exception.class, () -> {
			Venda retorno = this.vendaService.verificarStatus(venda);
		});
	}

}
