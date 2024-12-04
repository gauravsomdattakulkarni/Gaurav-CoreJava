package com.telusko.JobApplication;

public class ApiResponse<DataType> {
    private boolean status;
    private String message;
    private DataType data;

    public ApiResponse(boolean status, String message, DataType data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(boolean status, String message) {
        this(status, message, null);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataType getData() {
        return data;
    }

    public void setData(DataType data) {
        this.data = data;
    }
}
