package yte.intern.data.project.admin.controller.request;

import yte.intern.data.project.admin.entity.Admin;

public record UpdateAdminRequest(

        String username,
        String password

) {
    public Admin toDomainEntity() {

        return new Admin(username, password);
    }

}
