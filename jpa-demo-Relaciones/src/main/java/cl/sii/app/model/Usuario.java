package cl.sii.app.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.WhereJoinTable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;

@Entity
@Table(name="Usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String email;
	private String username;
	private String password;
	private Integer status;
	private Date fecharegistro;
	
	@ManyToAny(fetch = FetchType.EAGER)
	@JoinTable(name="UsuarioPerfil", 
				joinColumns = @JoinColumn(name="idUsuario"),
				inverseJoinColumns = @JoinColumn(name="idPerfil"))
	
	private List<Perfil> perfiles;
	
	
	public void agregar(Perfil perfil) {
		if(perfiles == null) {
			perfiles = new LinkedList<>();
		}
		perfiles.add(perfil);
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the fecharegistro
	 */
	public Date getFecharegistro() {
		return fecharegistro;
	}

	/**
	 * @param fecharegistro the fecharegistro to set
	 */
	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	/**
	 * @return the perfiles
	 */
	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	/**
	 * @param perfiles the perfiles to set
	 */
	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", status=" + status + ", fecharegistro=" + fecharegistro + ", perfiles="
				+ perfiles + "]";
	}
		
	//agregarPerfil	
}
