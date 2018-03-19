package bean;


import java.io.Serializable;

/**京东接口对接
 * @author jerome
 *
 */
public class REQUEST_FPKJXX implements Serializable {

	private static final long serialVersionUID = -7239877942353605683L;
	private  String ZXLX;

	private String ZXH;

	private String CKH;

	private FPKJXX_FPTXX FPKJXX_FPTXX;
	private FPKJXX_XMXX[] FPKJXX_XMXXS;

	public REQUEST_FPKJXX(String ZXLX, String ZXH, String CKH, FPKJXX_FPTXX FPKJXX_FPTXX, FPKJXX_XMXX[] FPKJXX_XMXXS) {
		this.ZXLX = ZXLX;
		this.ZXH = ZXH;
		this.CKH = CKH;
		this.FPKJXX_FPTXX = FPKJXX_FPTXX;
		this.FPKJXX_XMXXS = FPKJXX_XMXXS;
	}

	public REQUEST_FPKJXX() {
	}

	public String getZXLX() {
		return ZXLX;
	}

	public void setZXLX(String ZXLX) {
		this.ZXLX = ZXLX;
	}

	public String getZXH() {
		return ZXH;
	}

	public void setZXH(String ZXH) {
		this.ZXH = ZXH;
	}

	public String getCKH() {
		return CKH;
	}

	public void setCKH(String CKH) {
		this.CKH = CKH;
	}

	public FPKJXX_FPTXX getFPKJXX_FPTXX() {
		return FPKJXX_FPTXX;
	}

	public void setFPKJXX_FPTXX(FPKJXX_FPTXX FPKJXX_FPTXX) {
		this.FPKJXX_FPTXX = FPKJXX_FPTXX;
	}

	public FPKJXX_XMXX[] getFPKJXX_XMXXS() {
		return FPKJXX_XMXXS;
	}

	public void setFPKJXX_XMXXS(FPKJXX_XMXX[] FPKJXX_XMXXS) {
		this.FPKJXX_XMXXS = FPKJXX_XMXXS;
	}
}
