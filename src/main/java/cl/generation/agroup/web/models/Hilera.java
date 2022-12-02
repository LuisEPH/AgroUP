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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Table(name="hileras")
public class Hilera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nombreHilera;
	@NotNull
	private String descripcionHilera;

	
	//ManyToOne de Hilera proveniente de Terrenos
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="terreno_id")
	private Terreno terreno;
	
	//One to Many para Categorías
	@JsonIgnore
	@OneToMany(mappedBy = "hilera",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Categoria> categorias;

	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;//insertar registro
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;//modificar registro
}