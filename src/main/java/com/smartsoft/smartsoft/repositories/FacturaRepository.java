package com.smartsoft.smartsoft.repositories;

import com.smartsoft.smartsoft.model.Factura;
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
public class FacturaRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final SimpleJdbcInsert insert;
    private final FacturaRepository.FacturaMapper mapper = new FacturaRepository.FacturaMapper();

    private final String table = "factura";

    public FacturaRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        this.insert = new SimpleJdbcInsert(dataSource).withTableName(table).usingGeneratedKeyColumns("num_factura");
    }

    public List<Factura> getAllFacturas(){
        String sql = "select * from " + table;
        return jdbcTemplate.query(sql,mapper);
    }

    //METODO PARA TRAER LAS FACTURAS DE UN CLIENTE
    public List<Factura> getFacturasCliente(int idcli){
        String sql = "select * from factura where id_cliente ="+idcli;
        return jdbcTemplate.query(sql,mapper);
    }

    public long createFactura(Factura newFactura) {
        return insert.executeAndReturnKey(
                new MapSqlParameterSource("id_cliente",newFactura.id_cliente).addValue("fecha",newFactura.fecha)
        ).longValue();
    }

    private static class FacturaMapper implements RowMapper<Factura> {

        @Override
        public Factura mapRow(ResultSet rs, int rowNum) throws SQLException {
            long num_factura = rs.getLong("num_factura");
            long id_cliente = rs.getLong("id_cliente");
            String fecha = rs.getString("fecha");

            return new Factura(num_factura,id_cliente,fecha);
        }
    }
}
