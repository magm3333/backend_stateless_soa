package com.coop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.coop.model.dto.ProductoSintetico;

//Anotaciones JPA: http://www.datanucleus.org/products/accessplatform/jpa/annotations.html
@NamedNativeQueries({
	@NamedNativeQuery(
		name="productoSintetico",
		query="SELECT p.id as codigo,p.descripcion,r.rubro,precio FROM productos p inner join rubros r on p.id_rubro=r.id where precio>? order by rubro",
		resultSetMapping="productoSinteticoMapper"
	)
		
})
@SqlResultSetMappings({
	@SqlResultSetMapping(
			name="productoSinteticoMapper",
			
			//long id, String producto, String rubro, double precio
			classes= {
					@ConstructorResult(
							targetClass=ProductoSintetico.class,
							columns= {
									@ColumnResult(name="codigo",type=Long.class),
									@ColumnResult(name="descripcion",type=String.class),
									@ColumnResult(name="rubro",type=String.class),
									@ColumnResult(name="precio",type=Double.class)
							}
					)
			}
	)
})
@Entity
@Table(name="productos")
public class Producto implements Serializable{


	private static final long serialVersionUID = 6567964114155098009L;

	private Date fechaVencimiento;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private double precio;
	
	@Column(length=100, name="descripcion",nullable=false)
	private String producto;

	@ManyToOne
	@JoinColumn(name="id_rubro")
	private Rubro rubro;
	
	@ManyToMany
	@JoinTable(name="productos_proveedores",
		joinColumns= {
				@JoinColumn(
						name="id_producto",
						referencedColumnName="id")},
		inverseJoinColumns= {@JoinColumn(
				name="id_proveedor",
				referencedColumnName="id")}
		
	)
	private List<Proveedor> proveedores;

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public long getId() {
		return id;
	}

	public double getPrecio() {
		return precio;
	}

	@Transient
	public double getPrecioDoble() {
		return getPrecio()*2;
	}

	public String getProducto() {
		return producto;
	}
	

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	} 
	
	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	
}
