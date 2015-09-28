package com.merryyou.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created on 2015/9/23 0023.
 *
 * @author zhenglongfei
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBean<T extends Serializable> implements Serializable {

    /**
     * The serial version uid.
     */
    private static final long serialVersionUID = -482167849129199454L;


    private StatusBean status;

    private T content;

    /**
     * Instantiates a new Response bean.
     *
     * @param status the <code>Status</code> enum
     * @param desc   the desc
     */
    public ResponseBean(Status status, String desc) {
        this.status = new StatusBean(status, desc);
    }

    /**
     * Instantiates a new Response bean.
     *
     * @param status the status
     * @param reqKey the req key
     * @param desc   the desc
     */
    public ResponseBean(Status status, String reqKey, String desc) {
        this.status = new StatusBean(status, reqKey, desc);
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    @JsonProperty("status")
    public StatusBean getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(StatusBean status) {
        this.status = status;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    @JsonProperty("content")
    public T getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(T content) {
        this.content = content;
    }
}
