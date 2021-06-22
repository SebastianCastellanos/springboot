package com.example.demo.api;

public class CommonResult<T> {
    private long code;
    private String messgae;
    private T data;

    protected CommonResult(){

    }

    public CommonResult(long code, String messgae, T data) {
        this.code = code;
        this.messgae = messgae;
        this.data = data;
    }

    /**
     * 成功返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     * @param data      获取的数据
     * @param messgae   提示信息
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data, String messgae){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), messgae, data);
    }

    /**
     * 失败返回结果
     * @param errorCode  错误码
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode){
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param messgae
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(String messgae){
        return new CommonResult<T>(ResultCode.FAILED.getCode(),messgae, null);
    }

    /**
     * 失败返回结果
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(){
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validateFailed(){
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validateFailed(String messgae){
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), messgae, null);
    }

    /**
     * 未登录返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> unauthorized(T data){
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> forbidden(T data){
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
