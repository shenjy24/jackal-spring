package com.jonas.feature.transaction.mapper;

import com.jonas.feature.transaction.domain.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 表与实体的映射
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-10-16
 */
public class PlayerRowMapper implements RowMapper<Player> {

    @Override
    public Player mapRow(ResultSet resultSet, int i) throws SQLException {
        Player player = new Player(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getTimestamp("ctime"),
                resultSet.getTimestamp("utime"));
        return player;
    }
}
