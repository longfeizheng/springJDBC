package com.merryyou.db;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 2015/9/15 0015.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public abstract class AbstractColumnsMapper<T extends BaseEntity<ID>, ID extends Serializable>
        implements ColumnsMapper<T, ID> {

    /**
     * The constant WHERE.
     */
    protected static final String WHERE = " WHERE";

    /**
     * The constant SET.
     */
    protected static final String SET = " SET";


    /**
     * Do map columns in where clause.
     *
     * @param entity the entity
     * @param source the source
     * @return the list of string
     */
    protected abstract List<String> doMapColumnsInWhereClause(
            T entity, MapSqlParameterSource source);

    /**
     * Do map columns in set clause.
     *
     * @param entity the entity
     * @param source the source
     * @return the list of string
     */
    protected abstract List<String> doMapColumnsInSetClause(
            T entity, MapSqlParameterSource source);


    @Override
    public String mapColumnsInWhereClause(T entity, MapSqlParameterSource source) {
        Assert.notNull(entity, "The param [entity] can not be null.");
        Assert.notNull(source, "The param [source] can not be null.");

        List<String> frags = this.doMapColumnsInWhereClause(entity, source);
        if (ObjectUtils.isEmpty(frags)) {
            return StringUtils.EMPTY;
        } else {
            return WHERE + " " + Joiner.on(" AND ").join(frags);
        }
    }

    @Override
    public String mapColumnsInSetClause(T entity, MapSqlParameterSource source) {
        Assert.notNull(entity, "The param [entity] can not be null.");
        Assert.notNull(source, "The param [source] can not be null.");

        List<String> frags = this.doMapColumnsInSetClause(entity, source);
        if (ObjectUtils.isEmpty(frags)) {
            return StringUtils.EMPTY;
        } else {
            return SET + " " + Joiner.on(", ").join(frags);
        }
    }
}

