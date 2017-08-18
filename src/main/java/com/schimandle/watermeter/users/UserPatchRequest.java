package com.schimandle.watermeter.users;

import java.util.List;

public class UserPatchRequest {
    private List<UserPatch> userPatchList;

    public List<UserPatch> getUserPatchList() {
        return userPatchList;
    }

    public void setUserPatchList(List<UserPatch> userPatchList) {
        this.userPatchList = userPatchList;
    }
}
