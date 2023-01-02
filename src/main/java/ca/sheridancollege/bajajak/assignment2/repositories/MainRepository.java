package ca.sheridancollege.bajajak.assignment2.repositories;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;

import ca.sheridancollege.bajajak.assignment2.beans.Cheese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class MainRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final String INSERT_CHEESE_QUERY = "INSERT INTO CHEESES (NAME, QUANTITY, WEIGHT, UNITSID, PRICE, SPECSHEET) values(?,?,?,?,?,?) ";
    private static final String GET_ALL_CHEESE_QUERY = "SELECT * FROM CHEESES";

    public MainRepository() {
        super();
    }

    public void saveCheese(Cheese cheese) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        System.out.println("cheese  "+cheese);
        PreparedStatementCreator preparedStatementCreator = con -> {
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_CHEESE_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cheese.getName());
            preparedStatement.setInt(2, cheese.getQuantity());
            preparedStatement.setDouble(3, cheese.getWeight());
            preparedStatement.setInt(4, cheese.getUnitsId());
            preparedStatement.setDouble(5, cheese.getPrice());
            preparedStatement.setString(6, cheese.getSpecSheet());
            return preparedStatement;
        };

        jdbcTemplate.update(preparedStatementCreator, keyHolder);

        Optional<Number> key = Optional.ofNullable(keyHolder.getKey());
        key.ifPresent(number -> cheese.setId(number.intValue()));
    }



    public List<Cheese> findAllCheeses() {
        RowMapper<Cheese> rowMapper= (rs, rowNum) -> {
            Cheese cheese = new Cheese();
            cheese.setId(rs.getInt("id"));
            cheese.setName(rs.getString("name"));
            cheese.setQuantity(rs.getInt("quantity"));
            cheese.setWeight(rs.getInt("weight"));
            cheese.setUnitsId(rs.getInt("unitsId"));
            cheese.setPrice(rs.getDouble("price"));
            cheese.setSpecSheet(rs.getString("specsheet"));
            return cheese;
        };
        return jdbcTemplate.query(GET_ALL_CHEESE_QUERY, rowMapper);
    }
}
