package filmes.model;

import java.sql.Date;

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
	private Date DataLancamento;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DataLancamento == null) ? 0 : DataLancamento.hashCode());
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
		if (DataLancamento == null) {
			if (other.DataLancamento != null)
				return false;
		} else if (!DataLancamento.equals(other.DataLancamento))
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

	@Override
	public String toString() {
		return "FilmeModel [Id=" + Id + ", nome=" + nome + ", sinopse=" + sinopse + ", DataLancamento=" + DataLancamento
				+ "]";
	}
	
	
}