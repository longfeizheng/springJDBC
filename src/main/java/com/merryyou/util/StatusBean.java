package com.merryyou.util;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

/**
 * Created on 2015/9/23 0023.
 *
 * @author zhenglongfei
 * @since 1.0
 */
@JsonPropertyOrder({"code", "desc", "reqkey"})
public class StatusBean implements Serializable {

    /**
     * The serial version uid.
     */
    private static final long serialVersionUID = 3655647486907703461L;


    private int code;
    private String desc;

    private String reqkey;


    /**
     * Instantiates a new Status bean.
     *
     * @param status the <code>Status</code> enum
     * @param desc   the desc
     */
    public StatusBean(Status status, String desc) {
        this.code = status.getCode();
        this.desc = desc;

        this.reqkey = RequestIdUtils.generate();
    }

    /**
     * Instantiates a new Status bean.
     *
     * @param status the <code>Status</code> enum
     * @param desc   the desc
     * @param reqkey the reqkey
     */
    public StatusBean(Status status, String desc, String reqkey) {
        this(status, desc);

        this.setReqkey(reqkey);
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Gets desc.
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets desc.
     *
     * @param desc the desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Gets reqkey.
     *
     * @return the reqkey
     */
    public String getReqkey() {
        return reqkey;
    }

    /**
     * Sets reqkey.
     *
     * @param reqkey the reqkey
     */
    public void setReqkey(String reqkey) {
        this.reqkey = reqkey;
    }
}

