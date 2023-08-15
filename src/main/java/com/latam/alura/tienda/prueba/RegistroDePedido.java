package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ClienteDAO;
import com.latam.alura.tienda.dao.PedidoDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Cliente;
import com.latam.alura.tienda.modelo.ItemsPedido;
import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDePedido {

	public static void main(String[] args) {
		
		registrarProducto();
		
		EntityManager em = JPAUtils.getEntityManager();
		
		
		ProductoDAO productoDao = new ProductoDAO(em);
		Producto producto = productoDao.consultaPorId(1l);
		
		ClienteDAO clienteDAO  = new ClienteDAO(em);
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		
		
		Cliente cliente = new Cliente("Juan", "kdk4lq");
		Pedido pedido = new Pedido(cliente);
		pedido.agregarItems(new ItemsPedido(5, producto,pedido));
		
		em.getTransaction().begin();
		
		clienteDAO.guardar(cliente);
		pedidoDAO.guardar(pedido);
		
		em.getTransaction().commit();
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
