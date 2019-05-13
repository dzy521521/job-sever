package com.example.demo.util.response;

/**
 * 输出结果的封装
 * 只要get不要set,进行更好的封装
 * @param <T>
 */
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    private Result(){
        this.code=0;
        this.msg="success";
    }

    private Result(T data){
        this.code=0;
        this.msg="success";
        this.data=data;
    }

    private Result(CodeMsg mg) {
        if (mg==null){
            return;
        }
        this.code=mg.getCode();
        this.msg=mg.getMsg();
    }

    private Result(String mg) {
        if (mg==null){
            return;
        }
        this.code= -1;
        this.msg=mg;
    }


    /**
     * 成功时
     * @param <T>
     * @return
     */
    public static <T>  Result<T>  success(T data){
        return new Result<T>(data);
    }

    public static <T>  Result<T>  success(){
        return new Result<T>();
    }

    /**
     * 失败
     * @param <T>
     * @return
     */
    public static <T>  Result<T>  fail(CodeMsg mg){
        return  new Result<T>(mg);
    }

    public static <T>  Result<T>  fail(String mg){
        return  new Result<T>(mg);
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


    public T getData() {
        return data;
    }


}
