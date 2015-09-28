package com.merryyou.db;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.io.Serializable;

/**
 * Created on 2015/9/15 0015.
 *
 * @param <T>  the type parameter
 * @param <ID> the type parameter
 * @author zhenglongfei
 * @since 1.0
 */
public interface ColumnsMapper<T extends BaseEntity<ID>, ID extends Serializable> {

    /**
     * map columns to sql parameter source.
     *
     * @param entity the entity bean instance
     * @param source the source
     * @return the sql where clause
     */
    String mapColumnsInWhereClause(T entity, MapSqlParameterSource source);

    /**
     * Map columns in set clause.
     *
     * @param entity the entity
     * @param source the source
     * @return the string
     */
    String mapColumnsInSetClause(T entity, MapSqlParameterSource source);
}

