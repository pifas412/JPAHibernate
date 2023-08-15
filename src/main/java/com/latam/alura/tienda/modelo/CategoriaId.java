package com.latam.alura.tienda.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class CategoriaId implements Serializable{

	private String nombre;
	private String contraseña;
	
	public CategoriaId(String nombre, String contraseña) {
		this.nombre = nombre;
		this.contraseña = contraseña;
	}
	public CategoriaId() {
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	@Override
	public int hashCode() {
		return Objects.hash(contraseña, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaId other = (CategoriaId) obj;
		return Objects.equals(contraseña, other.contraseña) && Objects.equals(nombre, other.nombre);
	}
	
	
	
}
