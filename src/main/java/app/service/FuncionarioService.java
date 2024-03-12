package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Funcionario;
import app.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public String save (Funcionario funcionario) {
		
		this.funcionarioRepository.save(funcionario);
		return "Funcionario salvo com sucesso!";
	}
	
	public String update (Funcionario funcionario, long id) {
		
		funcionario.setId(id);
		this.funcionarioRepository.save(funcionario);
		return "Funcionario atualizado com sucesso!";
	}
	
	public String delete (long id) {
		
		this.funcionarioRepository.deleteById(id);
		return "Funcionario deletado com sucesso!";
	}
	
	public List<Funcionario> findAll() {
		 List<Funcionario> lista = this.funcionarioRepository.findAll();
		return lista;
	}
	
	public Funcionario findById(long id) {
		 Funcionario funcionario = this.funcionarioRepository.findById(id).get();
		return funcionario;
	}
	
	public List<Funcionario> findByNome(String nome) {
        return funcionarioRepository.findByNome(nome);
    }

    public List<Funcionario> findByIdade(int idade) {
        return funcionarioRepository.findByIdade(idade);
    }

    public List<Funcionario> findByMatricula(String matricula) {
        return funcionarioRepository.findByMatricula(matricula);
    }

}
