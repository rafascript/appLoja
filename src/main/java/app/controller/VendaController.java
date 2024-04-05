package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Venda;
import app.service.VendaService;



@RestController
@RequestMapping("/api/venda")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save (@RequestBody Venda venda) {
		try {
			String mensagem = this.vendaService.save(venda);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update (@RequestBody Venda venda,@PathVariable long id) {
		try {
			String mensagem = this.vendaService.update(venda, id);
			return new ResponseEntity<>(mensagem, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete (@PathVariable long id) {
		try {
			String mensagem = this.vendaService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
 
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Venda>> findAll() {
		try {
			List<Venda> lista = this.vendaService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Venda> findById(@PathVariable long id){
		try {
			Venda venda = this.vendaService.findById(id);
			return new ResponseEntity<>(venda, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByEndereco")
	public ResponseEntity<List<Venda>> findByEndereco(@RequestParam String endereco) {
		try {
			List<Venda> lista = this.vendaService.findByEndereco(endereco);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByValor")
	public ResponseEntity<List<Venda>> findByValor(@RequestParam double valor) {
		try {
			List<Venda> lista = this.vendaService.findByValor(valor);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findValorMaior")
	public ResponseEntity<List<Venda>> findValorMaior(@RequestParam double valor) {
		try {
			List<Venda> lista = this.vendaService.findValorMaior(valor);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findValorMenor")
	public ResponseEntity<List<Venda>> findValorMenor(@RequestParam double valor) {
		try {
			List<Venda> lista = this.vendaService.findValorMenor(valor);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
}
