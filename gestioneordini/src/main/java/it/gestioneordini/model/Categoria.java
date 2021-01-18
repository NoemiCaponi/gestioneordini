package it.gestioneordini.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="descrizione")
	private String descrizione;
	
	@ManyToMany(mappedBy = "categorie", fetch = FetchType.LAZY)
	private Set<Articolo> articoliCategoria=new HashSet<Articolo>();
	
	public Categoria() {
		
	}
	
	public Categoria(String descrizione) {
		this.descrizione=descrizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Set<Articolo> getArticoliCategoria() {
		return articoliCategoria;
	}

	public void setArticoliCategoria(Set<Articolo> articoliCategoria) {
		this.articoliCategoria = articoliCategoria;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", descrizione=" + descrizione + "]";
	}
	
	
	public boolean equals(Object o) {
		   if (this == o) return true;
		   if (o == null || getClass() != o.getClass()) return false;
		   Categoria categoria= (Categoria) o;
		   return Objects.equals(id, categoria.id);
		}

	public void addToArticolo(Articolo articoloInstance) {
		this.articoliCategoria.add(articoloInstance);
		articoloInstance.getCategorie().add(this);
		
	}
	
	public void removeFromArticolo(Articolo articoloInstance) {
		this.articoliCategoria.remove(articoloInstance);
		articoloInstance.getCategorie().remove(this);
	}
	
	@Override
	public int hashCode() {
	   return Objects.hash(id);
	}
}
