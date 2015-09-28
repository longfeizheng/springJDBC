package com.merryyou.db;

import java.io.Serializable;

/**
 * Created on 2015/9/15 0015.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public class BaseEntity<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 6302849584831554084L;


    private ID id;


    /**
     * Instantiates a new Base entity.
     */
    public BaseEntity() {
    }

    /**
     * Instantiates a new Base entity.
     *
     * @param id the id
     */
    public BaseEntity(ID id) {
        this.id = id;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public ID getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(ID id) {
        this.id = id;
    }
}
