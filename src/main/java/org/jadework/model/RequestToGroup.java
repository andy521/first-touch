package org.jadework.model;

public class RequestToGroup {

    private Integer groupId;
    private String msg;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "RequestToGroup{" +
                "groupId=" + groupId +
                ", msg='" + msg + '\'' +
                '}';
    }
}
