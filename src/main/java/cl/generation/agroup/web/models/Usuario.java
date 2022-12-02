package cl.generation.agroup.web.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull; //import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombre;
	@NotNull
	private String apellido;
	@NotNull
	private int edad;
	@NotNull
	private String genero;
	@NotNull
	private String correo;
	@NotNull
	private String password;
	@Transient
	private String password2;
	@NotNull
	private int telefono; 
	//ManyToOne de Empresa
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	
	// Relacion ManytoMany proveniente de roles

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "roles_usuarios", // nombre de la tabla relacional
			joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private List<Rol> roles;
	
	//One to Many para Registros Totales
	@JsonIgnore
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<RegistroTotal> registroTotales;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;//insertar registro
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;//modificar registro
}