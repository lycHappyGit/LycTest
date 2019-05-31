package HMAC_SHA1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * HmacSHA1工具类
 */
public class HmacSHA1Util {

	private static final Logger log = LoggerFactory.getLogger(HmacSHA1Util.class);

	/**
	 * HmacSHA1生成签名值
	 * @param data 数据
	 * @param key 密钥
	 * @return 签名值
	 */
	public static String hmacsha1(String data, String key) {
		String charset = "utf-8";
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(charset), "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);
			byte[] mac_byte = mac.doFinal(data.getBytes(charset));
			byte[] result_byte = java.util.Base64.getEncoder().encode(mac_byte);
			return new String(result_byte, charset);
		} catch (NoSuchAlgorithmException e) {
			log.error("NoSuchAlgorithmException", e);
		} catch (InvalidKeyException e) {
			log.error("InvalidKeyException", e);
		} catch (Exception e) {
			log.error("未知异常", e);
		}
		return null;
	}
}
