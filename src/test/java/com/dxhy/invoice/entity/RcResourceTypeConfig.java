package com.dxhy.invoice.entity;

public class RcResourceTypeConfig {
    private Integer id;

    private String resourceType;

    private String resourceTypeName;

    private Boolean usetemplate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }

    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    public Boolean getUsetemplate() {
        return usetemplate;
    }

    public void setUsetemplate(Boolean usetemplate) {
        this.usetemplate = usetemplate;
    }
}