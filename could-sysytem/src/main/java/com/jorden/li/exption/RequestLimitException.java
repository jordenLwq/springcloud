package com.jorden.li.exption;
/**
 * ****************************************************************
 *
 *    Copyright (c) 2001-2017 Digital Telemedia Co.,Ltd
 *    http://jordenlwq.github.io/
 *    Package:     com.jorden.li.exption
 *    Filename:    RequestLimitException.java
 *    Description: TODO(用一句话描述该文件做什么)
 *    Copyright:   Copyright (c) 2001-2014
 *    Company:     Digital Telemedia Co.,Ltd
 *    @author:     jorden.li
 *    @version:    1.0.0
 *    Create at:   2017年12月27日 上午9:56:10
 *    Revision:
 *    2017年12月27日 上午9:56:10
 *     - first revision
 ****************************************************************
 */
public class RequestLimitException extends Exception {
    static final long serialVersionUID = -7034897190745766939L;

    /** Constructs a new requestLimit exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public RequestLimitException() {
        super();
    }

    /** Constructs a new requestLimit exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    public RequestLimitException(String message) {
        super(message);
    }

    /**
     * Constructs a new requestLimit exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this requestLimit exception's detail message.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.4
     */
    public RequestLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    /** Constructs a new requestLimit exception with the specified cause and a
     * detail message of <tt>(cause==null ? null : cause.toString())</tt>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).  This constructor is useful for requestLimit exceptions
     * that are little more than wrappers for other throwables.
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.4
     */
    public RequestLimitException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new requestLimit exception with the specified detail
     * message, cause, suppression enabled or disabled, and writable
     * stack trace enabled or disabled.
     *
     * @param  message the detail message.
     * @param cause the cause.  (A {@code null} value is permitted,
     * and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression whether or not suppression is enabled
     *                          or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     *
     * @since 1.7
     */
    protected RequestLimitException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}