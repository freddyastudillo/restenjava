package com.smartsoft.smartsoft.repositories;

import com.smartsoft.smartsoft.model.Cliente;
import com.smartsoft.smartsoft.model.Producto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductoRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final SimpleJdbcInsert insert;
    private final ProductoRepository.ProductoMapper mapper = new ProductoRepository.ProductoMapper();

    private final String table = "producto";

    public ProductoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        this.insert = new SimpleJdbcInsert(dataSource).withTableName(table).usingGeneratedKeyColumns("id_producto");
    }

    public List<Producto> getAllProductos(){
        String sql = "select * from " + table;
        return jdbcTemplate.query(sql,mapper);
    }

    public long createProducto(Producto newProducto) {
        return insert.executeAndReturnKey(
                new MapSqlParameterSource("nombre",newProducto.nombre).addValue("precio",newProducto.precio)
                        .addValue("stock",newProducto.stock)
        ).longValue();
    }

    private static class ProductoMapper implements RowMapper<Producto> {

        @Override
        public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id_producto = rs.getLong("id_producto");
            String nombre = rs.getString("nombre");
            long precio = rs.getLong("precio");
            long stock = rs.getLong("stock");

            return new Producto(id_producto,nombre,precio,stock);
        }
    }
}
