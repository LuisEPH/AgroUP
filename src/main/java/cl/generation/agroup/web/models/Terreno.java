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
@Table(name="terrenos")
public class Terreno {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@NotNull
		private String nombreTerreno;
		
		//ManyToOne de Registrototal proveniente de Registros Totales
		@JsonIgnore
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="registro_id")
		private RegistroTotal registroTotal;
		
		//One to Many para Hilera
		@JsonIgnore
		@OneToMany(mappedBy = "terreno",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		private List<Hilera> hileras;

		@Column(updatable = false)
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date createdAt;//insertar registro
		
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updatedAt;//modificar registro
	
}