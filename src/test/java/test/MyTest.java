package test;

import bean.FPKJXX_FPTXX;
import bean.FPKJXX_XMXX;
import bean.REQUEST_FPKJXX;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.junit.Test;
import util.JavaCompilerUtil;
import util.Money2CNUtil;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class MyTest {


    @Test
    public void test1() {

        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, String> map2 = new HashMap<String, String>();

        map2.put("name", "zhangsan");
        map2.put("age", "12");
        map.put("code", "23");
        map.put("list", map2);

        String s = JSONObject.toJSONString(map);
        System.out.println(s);

    }

    @Test
    public void test2() {

        Gson gson = new Gson();

        FPKJXX_FPTXX fpt = new FPKJXX_FPTXX();
        fpt.setFPQQLSH("lsh12");
        fpt.setGHF_DZ("abc");

        FPKJXX_XMXX fpx = new FPKJXX_XMXX();
        fpx.setSE("123.09");
        fpx.setSL("0.08");

        REQUEST_FPKJXX fp = new REQUEST_FPKJXX();
        fp.setCKH("ckh123");
        fp.setFPKJXX_FPTXX(fpt);
        fp.setFPKJXX_XMXXS(new FPKJXX_XMXX[]{fpx});

        String gjson = gson.toJson(fp);
        String fastjson = JSON.toJSONString(fp);
        System.out.println("gson : " + gjson);
        System.out.println("fastjson : " + fastjson);
        new ArrayList<>();
    }

    @Test
    public void test3() {

        String money2cn = Money2CNUtil.money2CN(new BigDecimal("-200303123.12"));
        System.out.println(money2cn);
    }

    @Test
    public void test5() {
        DecimalFormat shotDf = new DecimalFormat("#.00");
        String s = shotDf.format(Double.parseDouble("50.00"));
        System.out.println(s);
    }

    @Test
    public void test6() throws UnsupportedEncodingException {
        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();
        final String text = "1+3>9>>*528<2<>>288**>-+>/613558/-6030*8*9361182/29<37->23++///20/1-9*0+3/29888>3-/9263+//++4079<8*536/1<-02";
        final byte[] textByte = text.getBytes("UTF-8");
        //编码
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);
        //解码
        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
    }

    @Test
    public void test7() throws UnsupportedEncodingException {
        boolean flag = JavaCompilerUtil.CompilerJavaFile("d:/GenPdfSignServiceImpl.java", "d:/");
        System.out.println(flag);
    }

    @Test
    public void test8() throws UnsupportedEncodingException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        int quarterInMonth = getQuarterInMonth(cal.get(Calendar.MONTH) + 1);

        cal.set(Calendar.MONTH, quarterInMonth - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        String exetime = sdf.format(cal.getTime());
        System.out.println(exetime);
    }

    // 返回第几个月份，不是几月
    // 季度一年四季， 第一季度：2月-4月， 第二季度：5月-7月， 第三季度：8月-10月， 第四季度：11月-1月
    private int getQuarterInMonth(int month) {
        int months[] = {3, 6, 9, 12};
        if (month >= 1 && month <= 3)
            return months[0];
        else if (month >= 4 && month <= 6)
            return months[1];
        else if (month >= 7 && month <= 9)
            return months[2];
        else
            return months[3];
    }

    @Test
    public void test9() throws Exception {

        double result1 = 0.5111;
        DecimalFormat df = new DecimalFormat("0.####%");
        String r = df.format(result1);
        System.out.println(r);
    }

    @Test
    public void test10() throws Exception {

        for (int i = 1; i <= 12; i++) {
            int[] months = {3, 6, 9, 12};
            int s = i % 3 == 0 ? i / 3 - 1 : i / 3;
            System.out.println(i + "月的季度末月是:" + months[s]);
        }

    }

}
