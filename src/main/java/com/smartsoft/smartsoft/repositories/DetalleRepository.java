package com.smartsoft.smartsoft.repositories;

import com.smartsoft.smartsoft.model.Detalle;
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
public class DetalleRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final SimpleJdbcInsert insert;
    private final DetalleRepository.DetalleMapper mapper = new DetalleRepository.DetalleMapper();

    private final String table = "detalle";

    public DetalleRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        this.insert = new SimpleJdbcInsert(dataSource).withTableName(table).usingGeneratedKeyColumns("num_detalle");
    }

    public List<Detalle> getAllDetalles(){
        String sql = "select * from " + table;
        return jdbcTemplate.query(sql,mapper);
    }


    //METODO PARA TRAER LOS DETALLES DE UNA FACTURA
    public List<Detalle> getFacDetalles(int idfac){
        String sql = "select * from detalle where id_factura ="+idfac;
        return jdbcTemplate.query(sql,mapper);
    }

    public long createDetalle(Detalle newDetalle) {
        return insert.executeAndReturnKey(
                new MapSqlParameterSource("id_factura",newDetalle.id_factura).addValue("id_producto",newDetalle.id_producto)
                        .addValue("cantidad",newDetalle.cantidad).addValue("precio",newDetalle.precio)
        ).longValue();
    }

    private static class DetalleMapper implements RowMapper<Detalle> {

        @Override
        public Detalle mapRow(ResultSet rs, int rowNum) throws SQLException {
            long num_detalle = rs.getLong("num_detalle");
            long id_factura = rs.getLong("id_factura");
            long id_producto = rs.getLong("id_producto");
            long cantidad = rs.getLong("cantidad");
            long precio = rs.getLong("precio");

            return new Detalle(num_detalle,id_factura,id_producto,cantidad,precio);
        }
    }
}
