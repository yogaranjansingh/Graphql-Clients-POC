package com.intuit.platform.integration.rpasClient.exception;

public class GraphqlClientException extends Throwable {
    public final Object reason;
    public final String message;

    public GraphqlClientException(Object reason) {
        this("", reason);
    }

    public GraphqlClientException(String message, Object reason) {
        this.message = message;
        this.reason = reason;
    }
}