package com.scarlatti.dao;

import com.scarlatti.Penguin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

/**
 * Created by pc on 9/19/2017.
 */
@Repository
public class PhilDao {
    @Autowired
    @Qualifier("philNamedParamJdbcTemplate")
    private NamedParameterJdbcTemplate namedParamJdbcTemplate;

    @Autowired
    @Qualifier("philJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_QUERY = "insert into penguin (name, nickname) values (:name, :nickname)";
    private final String SELECT_QUERY = "select * from penguin where name = :name and nickname = :nickname";
    private final String DELETE_QUERY = "delete from penguin";

    public void addPenguin(String name, String nickname) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);
        params.addValue("nickname", nickname);

        namedParamJdbcTemplate.update(INSERT_QUERY, params);
    }

    public void deletePenguins() {
        jdbcTemplate.update(DELETE_QUERY);
    }

    public Penguin getPenguin(String name, String nickname) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);
        params.addValue("nickname", nickname);

        return namedParamJdbcTemplate.queryForObject(SELECT_QUERY, params, (ResultSet rs, int rowNum) -> {
            Penguin penguin = new Penguin();
            penguin.setName(rs.getString("NAME"));
            penguin.setNickname(rs.getString("NICKNAME"));

            return penguin;
        });
    }
}
