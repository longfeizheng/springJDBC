package com.merryyou.db;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created on 2015/9/15 0015.
 * @param <T> the type parameter
 *
 * @author zhenglongfei
 * @since 1.0
 */
public interface CustomQueryRepository<T> {

    /**
     * Find all.
     *
     * @param entity the entity
     * @return the iterable
     */
    Iterable<T> findAll(T entity);

    /**
     * Find all.
     *
     * @param entity   the entity
     * @param pageable the pageable
     * @return the page
     */
    Page<T> findAll(T entity, Pageable pageable);
}

