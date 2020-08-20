package com.zy.springboottest.modules.common.vo;

public class Result<T> {
    private int status;
    private String message;
    private T Object;

    public Result() {
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(int status, String message, T object) {
        this.status = status;
        this.message = message;
        Object = object;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return Object;
    }

    public void setObject(T object) {
        Object = object;
    }

    public enum ResultStatus{
        SUCCESS(200),FAILD(500);
        public int status;

        ResultStatus(int status) {
            this.status = status;
        }
    }

    public enum IMAGE{
        ;
        public int width;
        public int height;
        public int size;

        IMAGE(int width, int height, int size) {
            this.width = width;
            this.height = height;
            this.size = size;
        }
    }
}
