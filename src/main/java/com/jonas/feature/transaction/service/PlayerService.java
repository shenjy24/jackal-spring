package com.jonas.feature.transaction.service;

import com.jonas.feature.transaction.domain.Player;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * AccountService
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-10-16
 */
@Transactional(propagation = Propagation.REQUIRED)
public interface PlayerService {
    void save(Player player);
}
