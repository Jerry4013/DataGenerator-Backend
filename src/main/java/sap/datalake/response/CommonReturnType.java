package sap.datalake.response;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/04
 **/
public class CommonReturnType {

    private String status;
    private Object data;

    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result, "success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
