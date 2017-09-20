package com.scarlatti.dao;

import com.scarlatti.Penguin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
/**
 * Created by pc on 9/19/2017.
 */
@Repository
public class DefaultDao {

//    @Autowired private NamedParameterJdbcTemplate namedParamJdbcTemplate;
//
//    private final String INSERT_QUERY = "insert into penguin (name, nickname) values (:name, :nickname)";
//    private final String SELECT_QUERY = "select * from penguin where name = :name and nickname = :nickname";
//
//    public void addPenguin(String name, String nickname) {
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("name", name);
//        params.addValue("nickname", nickname);
//
//        namedParamJdbcTemplate.update(INSERT_QUERY, params);
//    }
//
//    public Penguin getPenguin(String name, String nickname) {
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("name", name);
//        params.addValue("nickname", nickname);
//
//        return namedParamJdbcTemplate.queryForObject(SELECT_QUERY, params, (ResultSet rs, int rowNum) -> {
//                Penguin penguin = new Penguin();
//                penguin.setName(rs.getString("NAME"));
//                penguin.setNickname(rs.getString("NICKNAME"));
//
//                return penguin;
//        });
//    }
}
