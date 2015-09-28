package com.merryyou.dao;

import com.merryyou.db.CustomQueryRepository;
import com.merryyou.db.UpdatableRepository;
import com.merryyou.domain.AuthUser;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created on 2015/9/22 0022.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public interface AuthUserDao extends CustomQueryRepository<AuthUser>,
        UpdatableRepository<AuthUser>, PagingAndSortingRepository<AuthUser, String> {
}
