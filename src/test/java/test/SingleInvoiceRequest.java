package test;

/**
 * Created by thinkpad on 2017/6/10.
 */
public class SingleInvoiceRequest {
    private String taxNo;
    private String  invoiceType ;
    private String  invoiceNo ;
    private String  invoiceCode ;
    private String  invoiceDate ;
    private String  invoiceAmount ;
    private String  checkCode;

    @Override
    public String toString() {
        return "SingleInvoiceRequest{" +
                "taxNo='" + taxNo + '\'' +
                ", invoiceType='" + invoiceType + '\'' +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", invoiceCode='" + invoiceCode + '\'' +
                ", invoiceDate='" + invoiceDate + '\'' +
                ", invoiceAmount='" + invoiceAmount + '\'' +
                ", checkCode='" + checkCode + '\'' +
                '}';
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
