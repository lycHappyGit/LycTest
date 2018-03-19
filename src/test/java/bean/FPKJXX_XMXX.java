package bean;

import java.io.Serializable;

/**
 * 和移动对接接口报文
 * 
 * @author zsc
 * 
 */
public class FPKJXX_XMXX   implements Serializable {
    private static final long serialVersionUID = -112987794235305683L;

    private String XMMC;// 项目名称XMMC;//
    private String XMDW;// 项目单位XMDW;//
    private String GGXH;// 规格型号GGXH;//
    private String XMSL;// 项目数量XMSL;//
    private String HSBZ;// 含税标志HSBZ;//
    private String FPHXZ;// 发票行性质FPHXZ;//
    private String XMDJ;// 项目单价XMDJ;//
    private String SPBM;// 商品编码SPBM;//由项目编码修改为商品编码
    private String ZXBM;// 自行编码ZXBM;//
    private String YHZCBS;// 优惠政策标识YHZCBS;//
    private String LSLBS;// 零税率标识LSLBS;//
    private String ZZSTSGL;// 增值税特殊管理ZZSTSGL;//
    private String XMJE;// 项目金额XMJE;//
    private String SL;// 税率SL;//
    private String SE;// 税额SE;//
    private String BYZD1;// 备用字段BYZD1;//
    private String BYZD2;// 备用字段BYZD2;//
    private String BYZD3;// 备用字段BYZD3;//
    private String BYZD4;// 备用字段BYZD4;//
    private String BYZD5;// 备用字段BYZD5;//
    private String XMBM;//项目编码
    private String KCE;//扣除额
    private String HSXMDJ;//含税项目单价
    private String HSXMJE;//含税项目金额

    public String getXMMC() {
        return XMMC;
    }

    public void setXMMC(String xMMC) {
        XMMC = xMMC;
    }

    public String getXMDW() {
        return XMDW;
    }

    public void setXMDW(String xMDW) {
        XMDW = xMDW;
    }

    public String getGGXH() {
        return GGXH;
    }

    public void setGGXH(String gGXH) {
        GGXH = gGXH;
    }

    public String getXMSL() {
        return XMSL;
    }

    public void setXMSL(String xMSL) {
        XMSL = xMSL;
    }

    public String getHSBZ() {
        return HSBZ;
    }

    public void setHSBZ(String hSBZ) {
        HSBZ = hSBZ;
    }

    public String getFPHXZ() {
        return FPHXZ;
    }

    public void setFPHXZ(String fPHXZ) {
        FPHXZ = fPHXZ;
    }

    public String getXMDJ() {
        return XMDJ;
    }

    public void setXMDJ(String xMDJ) {
        XMDJ = xMDJ;
    }

    public String getSPBM() {
        return SPBM;
    }

    public void setSPBM(String sPBM) {
        SPBM = sPBM;
    }

    public String getZXBM() {
        return ZXBM;
    }

    public void setZXBM(String zXBM) {
        ZXBM = zXBM;
    }

    public String getYHZCBS() {
        return YHZCBS;
    }

    public void setYHZCBS(String yHZCBS) {
        YHZCBS = yHZCBS;
    }

    public String getLSLBS() {
        return LSLBS;
    }

    public void setLSLBS(String lSLBS) {
        LSLBS = lSLBS;
    }

    public String getZZSTSGL() {
        return ZZSTSGL;
    }

    public void setZZSTSGL(String zZSTSGL) {
        ZZSTSGL = zZSTSGL;
    }

    public String getXMJE() {
        return XMJE;
    }

    public void setXMJE(String xMJE) {
        XMJE = xMJE;
    }

    public String getSL() {
        return SL;
    }

    public void setSL(String sL) {
        SL = sL;
    }

    public String getSE() {
        return SE;
    }

    public void setSE(String sE) {
        SE = sE;
    }

    public String getBYZD1() {
        return BYZD1;
    }

    public void setBYZD1(String bYZD1) {
        BYZD1 = bYZD1;
    }

    public String getBYZD2() {
        return BYZD2;
    }

    public void setBYZD2(String bYZD2) {
        BYZD2 = bYZD2;
    }

    public String getBYZD3() {
        return BYZD3;
    }

    public void setBYZD3(String bYZD3) {
        BYZD3 = bYZD3;
    }

    public String getBYZD4() {
        return BYZD4;
    }

    public void setBYZD4(String bYZD4) {
        BYZD4 = bYZD4;
    }

    public String getBYZD5() {
        return BYZD5;
    }

    public void setBYZD5(String bYZD5) {
        BYZD5 = bYZD5;
    }

	public String getXMBM() {
		return XMBM;
	}

	public void setXMBM(String xMBM) {
		XMBM = xMBM;
	}

	public String getKCE() {
		return KCE;
	}

	public void setKCE(String kCE) {
		KCE = kCE;
	}


    public String getHSXMDJ() {
        return HSXMDJ;
    }

    public void setHSXMDJ(String BHSXMDJ) {
        this.HSXMDJ = BHSXMDJ;
    }

    public String getHSXMJE() {
        return HSXMJE;
    }

    public void setHSXMJE(String BHSXMJE) {
        this.HSXMJE = BHSXMJE;
    }
}
