package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.CategoriaId;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		
		registrarProducto();
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
		Producto producto = productoDAO.consultaPorId(1l);
		
		System.out.println(producto.getNombre());
		
		BigDecimal precio = productoDAO.consultarPrecioPorNombreDeProducto("Xiaomi");
				System.out.println(precio);
				
				Categoria find = em.find(Categoria.class, new CategoriaId("CELULARES","456" ));
				System.out.println(find.getNombre());
				
	}

		private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");
			
		Producto celular = new Producto("Xiaomi", "Muy bueno", new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		

		categoriaDAO.guardar(celulares);
		productoDAO.guardar(celular);
		
		em.getTransaction().commit();
		em.close();
	}

	
}
