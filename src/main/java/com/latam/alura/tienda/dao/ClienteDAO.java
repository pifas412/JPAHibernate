package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Cliente;

public class ClienteDAO {

	private EntityManager em;

	public ClienteDAO(EntityManager em) {
		this.em = em;
	}

	public void guardar (Cliente clliente) {
		this.em.persist(clliente);
	}
	
	public Cliente consultaPorId(Long id) {
		return em.find(Cliente.class, id);
	}
	
	public List<Cliente> consultarTodos(){
		String jpql = "SELECT P FROM Cliente AS P";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}
	
	public List<Cliente> consultaPorNombre(String nombre) {
		String jpql = "SELECT P FROM Cliente AS P WHERE P.nombre=:nombre";
		return em.createQuery(jpql,Cliente.class).setParameter("nombre", nombre).getResultList();
		
	}
	
	public List<Cliente> consultaPorNombreCategoria(String nombre){
		String jpql="SELECT P FROM Cliente AS P WHERE P.categoria.nombre=:nombre";
		return em.createQuery(jpql,Cliente.class).setParameter("nombre", nombre).getResultList();
	}
	
	public BigDecimal consultarPrecioPorNombreDeProducto(String nombre) {
		String jpql = "SELECT P.precio FROM Cliente AS P WHERE P.nombre=:nombre";
		return em.createQuery(jpql,BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
}
