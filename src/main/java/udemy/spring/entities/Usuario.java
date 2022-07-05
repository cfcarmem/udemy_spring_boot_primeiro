package udemy.spring.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private String fone;
	
	public Usuario() {
	}
	
	
	public Usuario(Long id, String name, String email, String password, String fone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.fone = fone;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFone() {
		return fone;
	}


	public void setFone(String fone) {
		this.fone = fone;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", fone=" + fone
				+ "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, fone, id, name, password);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(fone, other.fone) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}
	
	
	
	
	

}
