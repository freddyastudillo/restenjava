package com.smartsoft.smartsoft.repositories;

import com.smartsoft.smartsoft.model.Cliente;
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
public class ClienteRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final SimpleJdbcInsert insert;
    private final ClienteMapper mapper = new ClienteMapper();

    private final String table = "cliente";

    public ClienteRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        this.insert = new SimpleJdbcInsert(dataSource).withTableName(table).usingGeneratedKeyColumns("id_cliente");
    }

    public List<Cliente> getAllClientes(){
        String sql = "select * from " + table;
        return jdbcTemplate.query(sql,mapper);

    }

    public long createCliente(Cliente newCliente) {
        return insert.executeAndReturnKey(
                new MapSqlParameterSource("nombre",newCliente.nombre).addValue("apellido",newCliente.apellido)
                        .addValue("direccion",newCliente.direccion).addValue("fecha_nacimiento",newCliente.fecha_nacimiento)
                        .addValue("telefono",newCliente.telefono).addValue("email",newCliente.email)
        ).longValue();
    }

    private static class ClienteMapper implements RowMapper<Cliente>{

        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id_cliente = rs.getLong("id_cliente");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String direccion = rs.getString("direccion");
            String fecha_nacimiento = rs.getString("fecha_nacimiento");
            String telefono = rs.getString("telefono");
            String email = rs.getString("email");

            return new Cliente(id_cliente,nombre,apellido,direccion,fecha_nacimiento,telefono,email);
        }
    }

}
