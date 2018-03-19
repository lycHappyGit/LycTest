package bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * 
 * @author csf
 */
public class Result extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public Result() {
		put("RETURNCODE", 0000);
	}
	


	public static Result error(int code, String msg) {
		Result r = new Result();
		r.put("RETURNCODE", code);
		r.put("RETURNMESSAGE", msg);
		return r;
	}

	public static Result ok(String msg) {
		Result r = new Result();
		r.put("RETURNMESSAGE", msg);
		return r;
	}

	public static Result error(String msg) {
		Result r = new Result();
		r.put("RETURNCODE", 9999);
		r.put("RETURNMESSAGE", msg);
		return r;
	}
	
	public static Result ok(Map<String, Object> map) {
		Result r = new Result();
		r.putAll(map);
		return r;
	}
	
	public static Result ok() {
		return new Result();
	}

	public Result put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
