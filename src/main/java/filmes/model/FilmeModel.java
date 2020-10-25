package filmes.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "movieBase")
public class FilmeModel {
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String sinopse;
	
	@Column(nullable = false)
  	private String datalancamento;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getDataLancamento() {
		return datalancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		datalancamento = dataLancamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datalancamento == null) ? 0 : datalancamento.hashCode());
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sinopse == null) ? 0 : sinopse.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmeModel other = (FilmeModel) obj;
		if (datalancamento == null) {
			if (other.datalancamento != null)
				return false;
		} else if (!datalancamento.equals(other.datalancamento))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sinopse == null) {
			if (other.sinopse != null)
				return false;
		} else if (!sinopse.equals(other.sinopse))
			return false;
		return true;
	}
}