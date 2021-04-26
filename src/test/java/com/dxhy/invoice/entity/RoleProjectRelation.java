package com.dxhy.invoice.entity;

public class RoleProjectRelation {
    private Integer roleProjectId;

    private Integer roleId;

    private Integer projectId;

    public Integer getRoleProjectId() {
        return roleProjectId;
    }

    public void setRoleProjectId(Integer roleProjectId) {
        this.roleProjectId = roleProjectId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}