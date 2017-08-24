package org.jadework.model;

public class RequestToOne {
    private String toStaff;
    private String msg;

    public String getToStaff() {
        return toStaff;
    }

    public void setToStaff(String toStaff) {
        this.toStaff = toStaff;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "RequestToOne{" +
                "toStaff='" + toStaff + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
