package com.blueLine.java.webServices.blueline.spingService.common.serviceResponse;

public class ServiceResponse <T>{
    private T resultData=null;
    private boolean success=true;
    private String message;
    private int responseCode =200;

    public ServiceResponse(T resultData, boolean success, String message, int responseCode) {
        this.resultData = resultData;
        this.success = success;
        this.message = message;
        this.responseCode = responseCode;
    }

    public ServiceResponse(T resultData, String message) {
        this.resultData = resultData;
        this.message = message;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResultCode() {
        return responseCode;
    }

    public void setResultCode(int resultCode) {
        this.responseCode = resultCode;
    }

    @Override
    public String toString() {
        return "ServiceResponse{" +
                "resultData=" + resultData +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", responseCode=" + responseCode +
                '}';
    }
}
