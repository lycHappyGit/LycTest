package signTest;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * HmacSHA1工具类
 */
public class HmacSHA1Util {
	private static final Logger log = LoggerFactory.getLogger(HmacSHA1Util.class);

	/**
	 * HmacSHA1生成签名值
	 *
	 * @param data
	 *            数据
	 * @param key
	 *            密钥
	 * @return 签名值
	 */
	public static byte[] hmacsha1(byte[] data, byte[] key) {
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);
			return mac.doFinal(data);
		} catch (NoSuchAlgorithmException e) {
			log.error("NoSuchAlgorithmException", e);
		} catch (InvalidKeyException e) {
			log.error("InvalidKeyException", e);
		} catch (Exception e) {
			log.error("未知异常", e);
		}
		return null;
	}

	/**
	 * 生成签名
	 * @param url url请求+？
	 * @param signMap map参数
	 * @param secretKey 加密key
	 * @return 签名
	 * @throws Exception
	 */
	public static String genSign(String url, TreeMap<String, String> signMap, String secretKey) throws Exception {
		Boolean flag = Boolean.TRUE;
		StringBuilder keyVal = new StringBuilder();
		Iterator<Map.Entry<String, String>> iterator = signMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			// 值为空的不参与签名
			if (!entry.getValue().isEmpty()) {
				keyVal.append(String.format("%s=%s&", entry.getKey(), entry.getValue()));
			}else {
				flag =Boolean.FALSE;
				break;
			}
		}
		String signStr = "";
		if(flag){
            // 2、拼接API密钥
			String content = url + keyVal.toString().substring(0, keyVal.length() - 1);
			log.info("签名生成的String:{}",content);
			byte[] signBytes = hmacsha1(content.getBytes("UTF-8"), secretKey.getBytes("UTF-8"));
			signStr = Base64.encodeBase64String(signBytes);
		}
		return signStr;
	}




    public static int getRandNum(int min, int max) {
        int randNum = min + (int)(Math.random() * ((max - min) + 1));
        return randNum;
    }

}
