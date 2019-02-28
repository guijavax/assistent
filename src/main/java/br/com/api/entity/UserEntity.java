package br.com.api.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_assistent")
public class UserEntity {
	
	@Id
	@Column(name = "id_user_assistent")
	@GeneratedValue(generator="user_sequence")
	@SequenceGenerator(name="user_sequence", sequenceName="id_user")
	private Long idUsuario;

	@Column(name = "user_name", length = 20)
	@NotNull
	private String userName;
	
	@Column(name = "password", nullable = false)
	@NotNull
	private String password;
	
	@Column(name = "user_level", nullable = false, length = 1)
	@NotNull
	private Character userLevel;

	@Column(name = "active")
	private Boolean active;

	@OneToMany(mappedBy="usuario")
	private List<LoginEntity> login;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Character userLevel) {
		this.userLevel = userLevel;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
