package com.kte.actuator.customers;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    final JdbcTemplate jdbcTemplate;
    private final static String FIND_ALL = "SELECT * FROM customers";
    private RowMapper<Customer> customerRowMapper =
            (rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("email"));
    public List<Customer> search(){
        return  jdbcTemplate.query(FIND_ALL, customerRowMapper);
    }
}
