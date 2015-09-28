package com.merryyou.dao.daoimpl;

import com.google.common.collect.Lists;
import com.merryyou.dao.UserDao;
import com.merryyou.db.AbstractColumnsMapper;
import com.merryyou.db.AbstractDao;
import com.merryyou.db.ColumnsMapper;
import com.merryyou.domain.User;
import com.merryyou.util.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@CacheConfig(cacheNames = "user", keyGenerator = "defaultKeyGenerator")
public class UserDaoImpl extends AbstractDao<User, Integer> implements UserDao {

    private static final String TABLE_NAME = "user";

    private static class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();

            user.setId(rs.getInt(1));
            user.setFirstName(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setGender(rs.getString(4));
            user.setCity(rs.getString(5));

            return user;
        }
    }

    private static class UserColumnsMapper extends AbstractColumnsMapper<User, Integer> {

        @Override
        protected List<String> doMapColumnsInWhereClause(User entity,
                                                         MapSqlParameterSource source) {
            List<String> frags = Lists.newArrayList();
            if (entity.getId() != null) {
                frags.add(TABLE_NAME + ".id=:id");
                source.addValue("id", entity.getId());
            } else {
                if (!StringUtils.isEmpty(entity.getFirstName())) {
                    frags.add(TABLE_NAME + ".first_name=:first_name");
                    source.addValue("first_name", entity.getFirstName());
                }
            }

            return frags;
        }

        @Override
        protected List<String> doMapColumnsInSetClause(User entity, MapSqlParameterSource source) {
            List<String> frags = Lists.newArrayList();
            if (!StringUtils.isEmpty(entity.getFirstName())) {
                frags.add(TABLE_NAME + ".first_name=:first_name");
                source.addValue("first_name", entity.getFirstName());
            }
            if (!StringUtils.isEmpty(entity.getLastName())) {
                frags.add(TABLE_NAME + ".last_name=:last_name");
                source.addValue("last_name", entity.getLastName());
            }
            if (!StringUtils.isEmpty(entity.getGender())) {
                frags.add(TABLE_NAME + ".gender=:gender");
                source.addValue("gender", entity.getGender());
            }
            if (!StringUtils.isEmpty(entity.getCity())) {
                frags.add(TABLE_NAME + ".city=:city");
                source.addValue("city", entity.getCity());
            }
            return frags;
        }
    }

    public void insertData(User user) {
        String sql = "INSERT INTO " + TABLE_NAME + " "
                + "(first_name,last_name, gender, city) VALUES (:first_name, :last_name, :gender,:city)";

        MapSqlParameterSource args = new MapSqlParameterSource();
        args.addValue("first_name", user.getFirstName());
        args.addValue("last_name", user.getLastName());
        args.addValue("gender", user.getGender());
        args.addValue("city", user.getCity());

        getNamedParameterJdbcTemplate().update(sql, args);
    }

    public List<User> getUserList() {
        List userList;
        String sql = "select * from " + TABLE_NAME +" limit 0,20";
        userList = this.getNamedParameterJdbcTemplate().query(sql, new UserRowMapper());
        return userList;
    }

    @Override
    public void deleteData(String id) {
        String sql = "delete from " + TABLE_NAME + " where id=:id";

        MapSqlParameterSource args = new MapSqlParameterSource();
        args.addValue("id", id);

        this.getNamedParameterJdbcTemplate().update(sql, args);

    }

    @Override
    public void updateData(User user) {
        String sql = "UPDATE " + TABLE_NAME + " set first_name = :first_name,last_name = :last_name, gender = :gender, city = :city where id = :id";

        MapSqlParameterSource args = new MapSqlParameterSource();
        args.addValue("first_name", user.getFirstName());
        args.addValue("last_name", user.getLastName());
        args.addValue("gender", user.getGender());
        args.addValue("city", user.getCity());
        args.addValue("id", user.getId());

        this.getNamedParameterJdbcTemplate().update(sql, args);


    }

    @Override
    public User getUser(String id) {
        String sql = "select * from " + TABLE_NAME + " where id= :user_id";

        MapSqlParameterSource args = new MapSqlParameterSource();
        args.addValue("user_id", id);

        return this.getNamedParameterJdbcTemplate().queryForObject(sql, args, new UserRowMapper());
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected RowMapper<User> getRowMapper() {
        return new UserRowMapper();
    }

    @Override
    protected ColumnsMapper<User, Integer> getColumnsMapper() {
        return new UserColumnsMapper();
    }

    @Override
    public <S extends User> S save(S entity) {
        Assert.notNull(entity, "The param [entity] can not be null.");
        String sql = "INSERT INTO " + TABLE_NAME + " "
                + "(first_name,last_name, gender, city) VALUES (:first_name, :last_name, :gender,:city)";

        MapSqlParameterSource args = new MapSqlParameterSource();
        args.addValue("first_name", entity.getFirstName());
        args.addValue("last_name", entity.getLastName());
        args.addValue("gender", entity.getGender());
        args.addValue("city", entity.getCity());

        getNamedParameterJdbcTemplate().update(sql, args);
        return entity;
    }

    @Override
    public <S extends User> Iterable<S> save(Iterable<S> entities) {
        Assert.notNull(entities, "The param [entities] can not be null.");
        String sql = "INSERT INTO " + TABLE_NAME + " "
                + "(first_name,last_name, gender, city) VALUES (:first_name, :last_name, :gender,:city)";

        List<SqlParameterSource> spss = Lists.newArrayList();

        entities.forEach(entity -> {

            MapSqlParameterSource args = new MapSqlParameterSource();
            args.addValue("first_name", entity.getFirstName());
            args.addValue("last_name", entity.getLastName());
            args.addValue("gender", entity.getGender());
            args.addValue("city", entity.getCity());

            spss.add(args);
        });

        getNamedParameterJdbcTemplate().batchUpdate(
                sql, spss.toArray(new SqlParameterSource[spss.size()]));

        return entities;
    }

    @Override
    public void delete(Integer id) {
        Assert.notNull(id, "The param [id] can not be null.");

        String sql = "delete from " + TABLE_NAME + " where id=:id";

        MapSqlParameterSource args = new MapSqlParameterSource();
        args.addValue("id", id);

        this.getNamedParameterJdbcTemplate().update(sql, args);
    }

    @Override
    public void delete(User entity) {
        String sql = "delete from " + TABLE_NAME + " where id = :id";

        MapSqlParameterSource args = new MapSqlParameterSource();
        args.addValue("id", entity.getId());

        this.getNamedParameterJdbcTemplate().update(sql, args);
    }

    @Override
    public void delete(Iterable<? extends User> entities) {
        throw new NotImplementedException("Not Implemented yet");
    }

    @Override
    public void deleteAll() {
        throw new NotImplementedException("Not Implemented yet");
    }

    @Override
    @CachePut
    public <S extends User> S update(S entity) {
        Assert.notNull(entity, "The param [entity] can not be null.");
        Assert.notNull(entity.getId(), "The param [entity] must have the [id] property.");

        String sql = "UPDATE " + TABLE_NAME;

        UserColumnsMapper acm = new UserColumnsMapper();
        MapSqlParameterSource args = new MapSqlParameterSource();
        sql += acm.mapColumnsInSetClause(entity, args);
        sql += acm.mapColumnsInWhereClause(entity, args);

        getNamedParameterJdbcTemplate().update(sql, args);

        return super.update(entity);
    }

    @Override
    public <S extends User> Iterable<S> update(Iterable<S> entities) {
        throw new NotImplementedException("Not Implemented yet");
    }
}
