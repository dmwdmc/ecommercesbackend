package com.ecommerce.wrapper;

public class ErrorResponse implements java.io.Serializable{
    private int status;
    private String message;

    private String timestamp;
    public ErrorResponse(int status, String message, String timestamp){
        this.status=status;
        this.message=message;
        this.timestamp=timestamp;
    }
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}