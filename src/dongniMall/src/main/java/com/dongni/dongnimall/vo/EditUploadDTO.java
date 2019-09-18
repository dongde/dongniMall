package com.dongni.dongnimall.vo;

/**
 * 富文本文件上传返回格式
 */
public class EditUploadDTO {

    private Integer code;
    private String msg;
    private Object data;




    public EditUploadDTO(){
    }
    public EditUploadDTO(Integer code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static EditUploadDTO ok(Object data){
        return new EditUploadDTO(0,"",data);
    }

    public static EditUploadDTO errorMessage(String errormsg){
        return new EditUploadDTO(1,errormsg,null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
