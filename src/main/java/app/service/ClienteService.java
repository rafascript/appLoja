package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Cliente;
import app.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public String save (Cliente cliente) {
		
		this.clienteRepository.save(cliente);
		return "Cliente salvo com sucesso!";
	}
	
	public String update (Cliente cliente, long id) {
		
		cliente.setId(id);
		this.clienteRepository.save(cliente);
		return "Cliente atualizado com sucesso!";
	}
	
	public String delete (long id) {
		
		this.clienteRepository.deleteById(id);
		return "Cliente deletado com sucesso!";
	}
	
	public List<Cliente> findAll() {
		 List<Cliente> lista = this.clienteRepository.findAll();
		return lista;
	}
	
	public Cliente findById(long id) {
		 Cliente cliente = this.clienteRepository.findById(id).get();
		return cliente;
	}

}
