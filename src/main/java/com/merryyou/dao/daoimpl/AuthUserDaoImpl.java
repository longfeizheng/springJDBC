package com.merryyou.dao.daoimpl;

import com.google.common.collect.Lists;
import com.merryyou.dao.AuthUserDao;
import com.merryyou.db.AbstractColumnsMapper;
import com.merryyou.db.AbstractDao;
import com.merryyou.db.ColumnsMapper;
import com.merryyou.domain.AuthUser;
import com.merryyou.util.NotImplementedException;
import com.merryyou.util.Status;
import com.merryyou.util.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created on 2015/9/22 0022.
 *
 * @author zhenglongfei
 * @since 1.0
 */
@Repository
@CacheConfig(cacheNames = "auth_user", keyGenerator = "defaultKeyGenerator")
public class AuthUserDaoImpl extends AbstractDao<AuthUser, String> implements AuthUserDao {

    private static final String TABLE_NAME = "auth_user";

    private static class AuthUserRowMapper implements RowMapper<AuthUser> {

        @Override
        public AuthUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            AuthUser entity = new AuthUser();

            entity.setId(rs.getString("id"));
            entity.setUsername(rs.getString("username"));
            entity.setPassword(rs.getString("passwd"));
            entity.setRole(rs.getInt("role"));
            entity.setStatus(Status.fromCode(rs.getInt("status")));
            entity.setCreatedTime(new DateTime(rs.getTimestamp("created_time")));
            entity.setLastModifiedTime(new DateTime(rs.getTimestamp("last_modified_time")));

            return entity;
        }
    }

    private static class AuthUserCloumnsMapper extends AbstractColumnsMapper<AuthUser, String> {

        @Override
        protected List<String> doMapColumnsInWhereClause(AuthUser entity, MapSqlParameterSource source) {
            List<String> frags = Lists.newArrayList();
            if (entity.getId() != null) {
                frags.add(TABLE_NAME + ".id=:id");
                source.addValue("id", entity.getId());
            } else {
                if (!StringUtils.isEmpty(entity.getUsername())) {
                    frags.add(TABLE_NAME + ".username=:username");
                    source.addValue("username", entity.getUsername());
                }
                if (!StringUtils.isEmpty(entity.getPassword())) {
                    frags.add(TABLE_NAME + ".passwd=:passwd");
                    source.addValue("passwd", entity.getPassword());
                }
            }
            return null;
        }

        @Override
        protected List<String> doMapColumnsInSetClause(AuthUser entity, MapSqlParameterSource source) {
            List<String> frags = Lists.newArrayList();

            if (!StringUtils.isEmpty(entity.getPassword())) {
                frags.add(TABLE_NAME + ".passwd=:passwd");
                source.addValue("passwd", entity.getPassword());
            }
            if (entity.getStatus() != null) {
                frags.add(TABLE_NAME + ".status=:status");
                source.addValue("status", entity.getStatus().getCode());
            }
            if (entity.getRole() != null) {
                frags.add(TABLE_NAME + ".role=:role");
                source.addValue("role", entity.getRole());
            }

            frags.add("last_modified_time=now()");

            return frags;
        }
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected RowMapper<AuthUser> getRowMapper() {
        return new AuthUserRowMapper();
    }

    @Override
    protected ColumnsMapper<AuthUser, String> getColumnsMapper() {
        return new AuthUserCloumnsMapper();
    }

    @Override
    @CachePut
    public <S extends AuthUser> S save(S entity) {
        Assert.notNull(entity, "The param [entity] can not be null.");

        String sql = "INSERT INTO " + TABLE_NAME + " (id, username, passwd, role, status, created_time )" +
                " VALUES (:id, :username, :passwd, :role, :status, :created_time )";

        if (ObjectUtils.isEmpty(entity.getId())) {
            entity.setId(UUIDUtils.generateStr());
        }

        MapSqlParameterSource args = new MapSqlParameterSource();
        args.addValue("id", entity.getId());
        args.addValue("username", entity.getUsername());
        args.addValue("passwd", entity.getPassword());
        args.addValue("role", entity.getRole());
        args.addValue("status", entity.getStatus().getCode());
        args.addValue("created_time", entity.getCreatedTime().toDate());

        getNamedParameterJdbcTemplate().update(sql, args);

        return entity;
    }

    @Override
    public <S extends AuthUser> Iterable<S> save(Iterable<S> entities) {
        throw new NotImplementedException("Not Implemented yet");
    }

    @Override
    public void delete(String id) {
        Assert.notNull(id, "The param [id] can not be null.");

        AuthUser entity = new AuthUser(id);
        entity.setStatus(Status.NOT_AVAILABLE);

        this.update(entity);
    }

    @Override
    public void delete(AuthUser entity) {
        throw new NotImplementedException("Not Implemented yet");
    }

    @Override
    public void delete(Iterable<? extends AuthUser> entities) {
        throw new NotImplementedException("Not Implemented yet");
    }

    @Override
    public void deleteAll() {
        throw new NotImplementedException("Not Implemented yet");
    }

    @Override
    @CachePut
    public <S extends AuthUser> S update(S entity) {
        Assert.notNull(entity, "The param [entity] can not be null.");
        Assert.notNull(entity.getId(), "The param [entity] must have the [id] property.");

        String sql = "UPDATE " + TABLE_NAME;

        AuthUserCloumnsMapper acm = new AuthUserCloumnsMapper();
        MapSqlParameterSource args = new MapSqlParameterSource();
        sql += acm.mapColumnsInSetClause(entity, args);
        sql += acm.mapColumnsInWhereClause(entity, args);

        getNamedParameterJdbcTemplate().update(sql, args);

        return super.update(entity);
    }

    @Override
    public <S extends AuthUser> Iterable<S> update(Iterable<S> entities) {
        throw new NotImplementedException("Not Implemented yet");
    }
}
