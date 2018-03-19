package bean;

import java.io.Serializable;

/**
 * 和京东对接接口报文
 * 
 * @author jerome
 * 
 */
public class FPKJXX_FPTXX   implements Serializable {

	private static final long serialVersionUID = -112987794235305683L;
    private String ID;
	private String FPQQLSH;// 发票请求唯一流水号FPQQLSH;//
	private String DSPTBM;// 电商平台编码DSPTBM;//
	private String BMB_BBH;// 编码表版本号BMB_BBH;//
	private String XHF_NSRSBH;// 销货方识别号XHF_NSRSBH;//
	private String XHF_MC;// 销货方名称XHFMC;//
	private String XHF_DZ;// 销货方地址XHF_DZ;//
	private String XHF_DH;// 销货方电话XHF_DH;//
	private String XHF_YHZH;// 销货方银行账号XHF_YHZH;//
	private String GHF_MC;// 购货方名称GHFMC;//
	private String GHF_NSRSBH;// 购货方识别号GHF_NSRSBH;//
	private String GHF_DZ;// 购货方地址GHF_DZ;//
	private String GHF_GDDH;// 购货方固定电话GHF_GDDH;//
	private String GHF_SJ;// 购货方手机GHF_SJ;//
	private String GHF_EMAIL;// 购货方邮箱GHF_EMAIL;//
	private String GHF_QYLX;// 01GHFQYLX;//购货方企业类型
	private String GHF_YHZH;// 01GHF_YHZH;//
	private String HY_DM;// 行业代码HY_DM;//
	private String HY_MC;// 行业名称HY_MC;//
	private String KPY;// 开票员KPY;//
	private String SKY;// 收款员SKY;//
	private String FHR;// 复核人FHR;//
	private String KPRQ;// 开票日期KPRQ;//
	private String KPLX;// 开票类型KPLX;//
	private String YFP_DM;// 原发票代码YFP_DM;//
	private String YFP_HM;// 原发票号码YFP_HM;//
	private String QD_BZ;// 清单标志QD_BZ;//
	private String QDXMMC;// 清单发票项目名称QDXMMC;//
	private String CHYY;// 冲红原因CHYY;//
	private String KPHJJE;// 价税合计金额KPHJJE;//
	private String HJBHSJE;// 合计不含税金额HJBHSJE;//
	private String HJSE;// 合计税额HJSE;//
	private String BZ;// 备注BZ;//
	private String DDH;
	private String BYZD1;// 备用字段BYZD1;//
	private String BYZD2;// 备用字段BYZD2;//
	private String BYZD3;// 备用字段BYZD3;//
	private String BYZD4;// 备用字段BYZD4;//
	private String BYZD5;// 备用字段BYZD5;//


	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getFPQQLSH() {
		return FPQQLSH;
	}

	public void setFPQQLSH(String FPQQLSH) {
		this.FPQQLSH = FPQQLSH;
	}

	public String getDSPTBM() {
		return DSPTBM;
	}

	public void setDSPTBM(String DSPTBM) {
		this.DSPTBM = DSPTBM;
	}

	public String getBMB_BBH() {
		return BMB_BBH;
	}

	public void setBMB_BBH(String BMB_BBH) {
		this.BMB_BBH = BMB_BBH;
	}

	public String getXHF_NSRSBH() {
		return XHF_NSRSBH;
	}

	public void setXHF_NSRSBH(String XHF_NSRSBH) {
		this.XHF_NSRSBH = XHF_NSRSBH;
	}

	public String getXHF_MC() {
		return XHF_MC;
	}

	public void setXHF_MC(String XHF_MC) {
		this.XHF_MC = XHF_MC;
	}

	public String getXHF_DZ() {
		return XHF_DZ;
	}

	public void setXHF_DZ(String XHF_DZ) {
		this.XHF_DZ = XHF_DZ;
	}

	public String getXHF_DH() {
		return XHF_DH;
	}

	public void setXHF_DH(String XHF_DH) {
		this.XHF_DH = XHF_DH;
	}

	public String getXHF_YHZH() {
		return XHF_YHZH;
	}

	public void setXHF_YHZH(String XHF_YHZH) {
		this.XHF_YHZH = XHF_YHZH;
	}

	public String getGHF_MC() {
		return GHF_MC;
	}

	public void setGHF_MC(String GHF_MC) {
		this.GHF_MC = GHF_MC;
	}

	public String getGHF_NSRSBH() {
		return GHF_NSRSBH;
	}

	public void setGHF_NSRSBH(String GHF_NSRSBH) {
		this.GHF_NSRSBH = GHF_NSRSBH;
	}

	public String getGHF_DZ() {
		return GHF_DZ;
	}

	public void setGHF_DZ(String GHF_DZ) {
		this.GHF_DZ = GHF_DZ;
	}

	public String getGHF_GDDH() {
		return GHF_GDDH;
	}

	public void setGHF_GDDH(String GHF_GDDH) {
		this.GHF_GDDH = GHF_GDDH;
	}

	public String getGHF_SJ() {
		return GHF_SJ;
	}

	public void setGHF_SJ(String GHF_SJ) {
		this.GHF_SJ = GHF_SJ;
	}

	public String getGHF_EMAIL() {
		return GHF_EMAIL;
	}

	public void setGHF_EMAIL(String GHF_EMAIL) {
		this.GHF_EMAIL = GHF_EMAIL;
	}

	public String getGHF_QYLX() {
		return GHF_QYLX;
	}

	public void setGHF_QYLX(String GHF_QYLX) {
		this.GHF_QYLX = GHF_QYLX;
	}

	public String getGHF_YHZH() {
		return GHF_YHZH;
	}

	public void setGHF_YHZH(String GHF_YHZH) {
		this.GHF_YHZH = GHF_YHZH;
	}

	public String getHY_DM() {
		return HY_DM;
	}

	public void setHY_DM(String HY_DM) {
		this.HY_DM = HY_DM;
	}

	public String getHY_MC() {
		return HY_MC;
	}

	public void setHY_MC(String HY_MC) {
		this.HY_MC = HY_MC;
	}

	public String getKPY() {
		return KPY;
	}

	public void setKPY(String KPY) {
		this.KPY = KPY;
	}

	public String getSKY() {
		return SKY;
	}

	public void setSKY(String SKY) {
		this.SKY = SKY;
	}

	public String getFHR() {
		return FHR;
	}

	public void setFHR(String FHR) {
		this.FHR = FHR;
	}

	public String getKPRQ() {
		return KPRQ;
	}

	public void setKPRQ(String KPRQ) {
		this.KPRQ = KPRQ;
	}

	public String getKPLX() {
		return KPLX;
	}

	public void setKPLX(String KPLX) {
		this.KPLX = KPLX;
	}

	public String getYFP_DM() {
		return YFP_DM;
	}

	public void setYFP_DM(String YFP_DM) {
		this.YFP_DM = YFP_DM;
	}

	public String getYFP_HM() {
		return YFP_HM;
	}

	public void setYFP_HM(String YFP_HM) {
		this.YFP_HM = YFP_HM;
	}

	public String getQD_BZ() {
		return QD_BZ;
	}

	public void setQD_BZ(String QD_BZ) {
		this.QD_BZ = QD_BZ;
	}

	public String getQDXMMC() {
		return QDXMMC;
	}

	public void setQDXMMC(String QDXMMC) {
		this.QDXMMC = QDXMMC;
	}

	public String getCHYY() {
		return CHYY;
	}

	public void setCHYY(String CHYY) {
		this.CHYY = CHYY;
	}

	public String getKPHJJE() {
		return KPHJJE;
	}

	public void setKPHJJE(String KPHJJE) {
		this.KPHJJE = KPHJJE;
	}

	public String getHJBHSJE() {
		return HJBHSJE;
	}

	public void setHJBHSJE(String HJBHSJE) {
		this.HJBHSJE = HJBHSJE;
	}

	public String getHJSE() {
		return HJSE;
	}

	public void setHJSE(String HJSE) {
		this.HJSE = HJSE;
	}

	public String getBZ() {
		return BZ;
	}

	public void setBZ(String BZ) {
		this.BZ = BZ;
	}

	public String getBYZD1() {
		return BYZD1;
	}

	public void setBYZD1(String BYZD1) {
		this.BYZD1 = BYZD1;
	}

	public String getBYZD2() {
		return BYZD2;
	}

	public void setBYZD2(String BYZD2) {
		this.BYZD2 = BYZD2;
	}

	public String getBYZD3() {
		return BYZD3;
	}

	public void setBYZD3(String BYZD3) {
		this.BYZD3 = BYZD3;
	}

	public String getBYZD4() {
		return BYZD4;
	}

	public void setBYZD4(String BYZD4) {
		this.BYZD4 = BYZD4;
	}

	public String getBYZD5() {
		return BYZD5;
	}

	public void setBYZD5(String BYZD5) {
		this.BYZD5 = BYZD5;
	}

	public String getDDH() {
		return DDH;
	}

	public void setDDH(String DDH) {
		this.DDH = DDH;
	}
}
