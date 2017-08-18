package com.schimandle.watermeter.users;

public class UserPatch {
    private UserPropertyEnum userPropertyEnum;
    private Object value;

    public UserPropertyEnum getUserPropertyEnum() {
        return userPropertyEnum;
    }

    public void setUserPropertyEnum(UserPropertyEnum userPropertyEnum) {
        this.userPropertyEnum = userPropertyEnum;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
