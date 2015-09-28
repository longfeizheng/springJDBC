package com.merryyou.db;

/**
 * Created on 2015/9/15 0015.
 * @param <T> the type parameter
 *
 * @author zhenglongfei
 * @since 1.0
 */
public interface UpdatableRepository<T> {

    /**
     * Updates a given entity.
     *
     * @param <S>    the type parameter
     * @param entity the entity
     * @return the updated entity
     */
    <S extends T> S update(S entity);

    /**
     * Updates all given entities.
     *
     * @param <S>      the type parameter
     * @param entities the entities
     * @return the updated entities
     */
    <S extends T> Iterable<S> update(Iterable<S> entities);
}