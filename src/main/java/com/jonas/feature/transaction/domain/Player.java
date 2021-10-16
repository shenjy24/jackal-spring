package com.jonas.feature.transaction.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


/**
 * Account
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-10-16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private int id;
    private String name;
    private Timestamp ctime;
    private Timestamp utime;

    public Player(String name, Timestamp ctime, Timestamp utime) {
        this.name = name;
        this.ctime = ctime;
        this.utime = utime;
    }
}
