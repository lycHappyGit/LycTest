package socket;

/**
 * Created by sunpe on 2018/7/31.
 */
public class MsgUtil {


//
//    public static String back(){
//        PrintResultInfo r = new PrintResultInfo();
//        r.setQqlsh("9328282832480");
//        r.setFpzl("s");
//        r.setFpdm("5000153560");
//        r.setFphm("29434865");
//        r.setSpotKey("uuu9");
//        r.setCode("0000");
//        r.setMsg("打印成功");
//        return StringUtil.packMsg("03"+JSON.toJSONString(r));
//    }

    public static boolean isNullOrEmpty(String str) {
        return null == str || 0 == str.trim().length();
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean isNotEmpty(String str) {
        return str != null && !"".equals(str.trim());
    }

    public static String formatLike(String str) {
        return isNotEmpty(str)?"%" + str + "%":null;
    }

    public static  String fillLeftZero(int i){
        return String.format("%08d",i);
    }

    public static Integer strToInt(String str){
        return Integer.parseInt(str);
    }

    public static String packMsg(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(fillLeftZero(str.getBytes().length)).append(str);
        return sb.toString();
    }
}
