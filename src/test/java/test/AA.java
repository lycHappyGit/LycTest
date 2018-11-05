package test;

import java.sql.Timestamp;

public class AA {

    private Timestamp billingDate;

    private String name = "abc";

    public Timestamp getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Timestamp billingDate) {
        this.billingDate = billingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
