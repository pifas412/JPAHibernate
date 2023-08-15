package com.latam.alura.tienda.vo;

import java.time.LocalDate;

public class RelatorioDeVenta {
	private String nombreDeProducto;
	private Long CantidadDeProducto;
	private LocalDate FechaUltimaVenta;

	public RelatorioDeVenta(String nombreDeProducto, Long cantidadDeProducto, LocalDate fechaUltimaVenta) {
		this.nombreDeProducto = nombreDeProducto;
		CantidadDeProducto = cantidadDeProducto;
		FechaUltimaVenta = fechaUltimaVenta;
	}

	public String getNombreDeProducto() {
		return nombreDeProducto;
	}

	public void setNombreDeProducto(String nombreDeProducto) {
		this.nombreDeProducto = nombreDeProducto;
	}

	public Long getCantidadDeProducto() {
		return CantidadDeProducto;
	}

	public void setCantidadDeProducto(Long cantidadDeProducto) {
		CantidadDeProducto = cantidadDeProducto;
	}

	public LocalDate getFechaUltimaVenta() {
		return FechaUltimaVenta;
	}

	public void setFechaUltimaVenta(LocalDate fechaUltimaVenta) {
		FechaUltimaVenta = fechaUltimaVenta;
	}

	@Override
	public String toString() {
		return "RelatorioDeVenta [nombreDeProducto=" + nombreDeProducto + ", CantidadDeProducto=" + CantidadDeProducto
				+ ", FechaUltimaVenta=" + FechaUltimaVenta + "]";
	}

	
	
	

}
