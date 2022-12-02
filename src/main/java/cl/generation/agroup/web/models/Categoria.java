package cl.generation.agroup.web.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table (name="categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombreCategoria;
	@NotNull
	private Long valorCaja;
	
	//ManyToOne de Categoria proveniente de Hileras
		@JsonIgnore
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="hilera_id")
		private Hilera hilera;

		@Column(updatable = false)
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date createdAt;//insertar registro
		
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updatedAt;//modificar registro
}
