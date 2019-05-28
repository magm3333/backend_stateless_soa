package com.coop.model.persistence;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coop.model.Producto;
import com.coop.model.dto.ProductoSintetico;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	
	//https://docs.spring.io/spring-data/jpa/docs/2.1.3.RELEASE/reference/html/#repositories.query-methods.details (ver Table 3. Supported keywords inside method names)
	public List<Producto> findByProductoLike(String parteDelNombre);

	public List<Producto> findByPrecioBetween(double precioDesde, double precioHasta);

	@Query(name="productoSintetico",nativeQuery=true)
	public List<ProductoSintetico> listadoSintetico(double precioMinimo);

	@Query(value="SELECT COUNT(*) FROM productos WHERE precio>?",nativeQuery=true)
	public Long cantidadProductosMasCarosQue(double precioMinimo);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE productos SET precio=? WHERE id=?",nativeQuery=true)
	public int updatePrecio(double precio, long id);
	
	//public List<Producto> findByProductoLike(String parte,Pageable pageable, );
}
