package com.merryyou.db;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.merryyou.util.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 2015/9/15 0015.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public abstract class AbstractDao<T extends BaseEntity<ID>, ID extends Serializable>
        extends BaseDao implements CustomQueryRepository<T>,
        UpdatableRepository<T>, PagingAndSortingRepository<T, ID> {
    /**
     * Gets table name.
     *
     * @return the table name
     */
    protected abstract String getTableName();

    /**
     * Gets row mapper.
     *
     * @return the row mapper
     */
    protected abstract RowMapper<T> getRowMapper();

    /**
     * Gets columns mapper.
     *
     * @return the columns mapper
     */
    protected abstract ColumnsMapper<T, ID> getColumnsMapper();


    @Override
    public Iterable<T> findAll(Sort sort) {
        String sql = "SELECT * FROM " + getTableName() + sqlOrderBy(sort);

        return getNamedParameterJdbcTemplate().query(sql, getRowMapper());
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        String sql = "SELECT * FROM " + getTableName() + sqlPageable(pageable);

        List<T> results
                = getNamedParameterJdbcTemplate().query(sql, getRowMapper());

        return new PageImpl<>(results, pageable, count());
    }

    @Override
    public T findOne(ID id) {
        Assert.notNull(id, "The param [id] can not be null.");

        String sql = "SELECT * FROM " + getTableName() + " WHERE id = :id";
        MapSqlParameterSource args = new MapSqlParameterSource();
        args.addValue("id", id);

        try {
            return getNamedParameterJdbcTemplate().queryForObject(
                    sql, args, getRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean exists(ID id) {
        return findOne(id) != null;
    }

    @Override
    public Iterable<T> findAll() {
        String sql = "SELECT * FROM " + getTableName();

        return getJdbcTemplate().query(sql, getRowMapper());
    }

    @Override
    public Iterable<T> findAll(Iterable<ID> ids) {
        Assert.notNull(ids, "The param [ids] can not be null.");

        String sql = "SELECT * FROM " + getTableName() + " WHERE id IN (:ids)";

        List<String> idList = Lists.newArrayList();
        ids.forEach(uuid -> idList.add(uuid.toString()));
        MapSqlParameterSource args = new MapSqlParameterSource();
        args.addValue("ids", Joiner.on(", ").join(idList));

        return getNamedParameterJdbcTemplate().query(sql, args, getRowMapper());
    }

    @Override
    public long count() {
        return count(getTableName());
    }

    @Override
    public Iterable<T> findAll(T entity) {
        String sqlBase = "SELECT * FROM " + getTableName();

        MapSqlParameterSource args = new MapSqlParameterSource();

        ColumnsMapper<T, ID> columnsMapper = getColumnsMapper();
        String whereClause = columnsMapper.mapColumnsInWhereClause(entity, args);

        String sql = sqlBase + whereClause;
        return getNamedParameterJdbcTemplate().query(sql, args, getRowMapper());
    }

    @Override
    public Page<T> findAll(T entity, Pageable pageable) {
        String sqlBase = "SELECT * FROM " + getTableName();

        MapSqlParameterSource args = new MapSqlParameterSource();

        ColumnsMapper<T, ID> columnsMapper = getColumnsMapper();
        String whereClause = columnsMapper.mapColumnsInWhereClause(entity, args);
        String pageClause = sqlPageable(pageable);

        String sql = sqlBase + whereClause + pageClause;
        List<T> results = getNamedParameterJdbcTemplate().query(sql, args, getRowMapper());

        return new PageImpl<>(results, pageable, count(getTableName(), whereClause, args));
    }


    @Override
    public <S extends T> S update(S entity) {
        T one = findOne(entity.getId());
        BeanUtils.copyNonNullProperties(entity, one);
        return entity;
    }
}
