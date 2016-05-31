package com.merryyou.db;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created on 2015/9/15 0015.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public abstract class BaseDao {
    @Resource
    private JdbcDao jdbcDao;
    @Resource
    protected StringRedisTemplate stringRedisTemplate;
    @Resource
    protected RedisTemplate redisTemplate;


    /**
     * Gets name parameter jdbc template.
     *
     * @return the name parameter jdbc template
     */
    protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return jdbcDao.getNamedParameterJdbcTemplate();
    }

    /**
     * Gets jdbc template.
     *
     * @return the jdbc template
     */
    protected JdbcTemplate getJdbcTemplate() {
        return jdbcDao.getJdbcTemplate();
    }


    /**
     * Count int.
     *
     * @param table the table
     * @return the count
     */
    protected long count(String table) {
        return count(table, null, null);
    }

    /**
     * Count int.
     *
     * @param table       the table
     * @param whereClause the where clause
     * @param args        the args
     * @return the count
     */
    protected long count(String table, String whereClause, SqlParameterSource args) {
        String sql = "SELECT count(*) count FROM " + table;

        if (StringUtils.isNotEmpty(whereClause)) {
            sql += whereClause;
        }

        if (ObjectUtils.isEmpty(args)) {
            return getJdbcTemplate().queryForObject(sql, Long.class);
        } else {
            return getNamedParameterJdbcTemplate().queryForObject(sql, args, Long.class);
        }
    }

    /**
     * Sql order by.
     *
     * @param sort the sort
     * @return the string
     */
    protected String sqlOrderBy(Sort sort) {
        if (ObjectUtils.isEmpty(sort) || Iterables.size(sort) < 1) {
            return StringUtils.EMPTY;
        }

        StringBuilder sql = new StringBuilder(" ORDER BY ");

        List<String> orderList = Lists.newArrayList();
        sort.forEach(order ->
                orderList.add(order.getProperty() + " " + order.getDirection().name()));
        sql.append(Joiner.on(", ").join(orderList));

        return sql.toString();
    }

    /**
     * Sql pageable.
     *
     * @param pageable the pageable
     * @return the sql page clause string
     */
    protected String sqlPageable(Pageable pageable) {
        if (ObjectUtils.isEmpty(pageable)) {
            return StringUtils.EMPTY;
        }

        return sqlOrderBy(pageable.getSort())
                + " LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
    }
}
