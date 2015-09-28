package com.merryyou.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.Serializable;

/**
 * Created on 2015/9/15 0015.
 *
 * @author zhenglongfei
 * @since 1.0
 */
@Component
public class JdbcDao extends NamedParameterJdbcDaoSupport implements Serializable {

    private static final long serialVersionUID = 5540379307999415321L;


    private String dbSchema;


    /**
     * Instantiates a new Jdbc dao.
     *
     * @param dataSource the data source
     */
    @Autowired
    public JdbcDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }


    /**
     * Gets db schema.
     *
     * @return the db schema
     */
    public String getDbSchema() {
        return dbSchema;
    }

    /**
     * Sets db schema.
     *
     * @param dbSchema the db schema
     */
    public void setDbSchema(String dbSchema) {
        this.dbSchema = dbSchema;
    }
}

