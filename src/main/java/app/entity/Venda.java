package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	String endereco;

	double valor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("vendas")
	Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("vendas")
	Funcionario funcionario;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "venda_produto")
	private List<Produto> produtos;
		
}
