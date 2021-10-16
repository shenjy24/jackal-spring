package com.jonas.feature.transaction.service.impl;

import com.jonas.feature.transaction.domain.Player;
import com.jonas.feature.transaction.service.PlayerService;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * AccountServiceImpl
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-10-16
 */
public class PlayerServiceImpl implements PlayerService {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Player player) {
        jdbcTemplate.update("insert into player (name, ctime, utime) values (?,?,?)",
                new Object[]{player.getName(), player.getCtime(), player.getUtime()},
                new int[] {Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP});

        //事务测试，默认情况下Spring中的事务处理只对RuntimeException进行回滚
//        throw new RuntimeException("事务测试");
    }
}
