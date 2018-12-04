package test;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import enumtest.QueueType;
import freemark.FreeMarkerUtil;
import org.junit.Test;

import util.JavaCompilerUtil;
import util.Money2CNUtil;
import bean.FPKJXX_FPTXX;
import bean.FPKJXX_XMXX;
import bean.REQUEST_FPKJXX;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;


public class MyTest {


    @Test
    public void test1() {

        String s = null;
        QueueType fm = QueueType.UPLOAD;
        switch (fm) {
            case FM:
                s = "a";
                break;
            case QZ:
                s = "b";
                break;
            case TS:
                s = "c";
                break;
            case UPLOAD:
                s = "d";
                break;
        }
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

        String name = "liufeiyu6@163.com";
        String pwd = "lzc19910416";
        String a = new String(org.apache.commons.codec.binary.Base64.encodeBase64(name.getBytes("utf-8")), "utf-8");
        String b = new String(org.apache.commons.codec.binary.Base64.encodeBase64(pwd.getBytes("utf-8")), "utf-8");
        System.out.println("name: " + a);
        System.out.println("pwd: " + b);
    }

    @Test
    public void test11() throws Exception {

        String s = "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";
        byte[] bytes = org.apache.commons.codec.binary.Base64.decodeBase64(s.getBytes("utf-8"));

        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:/tmp/fpxx_0_fp.xml"));
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    @Test
    public void test16() throws Exception {

        FileInputStream fis = new FileInputStream(new File("D:/tmp/abc.txt"));
        FileOutputStream fos = new FileOutputStream(new File("d:/tmp/abccopy.png"));
        int len = 0;
        byte[] tmp = new byte[1024 * 100];
        fis.read(tmp);
        byte[] base64 = org.apache.commons.codec.binary.Base64.decodeBase64(tmp);
        fos.write(base64);
        fis.close();
        fos.close();
    }

    @Test
    public void test17() throws Exception {

        FileInputStream fis = new FileInputStream(new File("D:/tmp/abc.jpg"));
        FileWriter fw = new FileWriter(new File("D:/tmp/abc.txt"));
        byte[] tmp = new byte[1024 * 100];
        fis.read(tmp);
        byte[] base64 = org.apache.commons.codec.binary.Base64.encodeBase64(tmp);
        String s = new String(base64, "utf-8");
        fw.write(s);
    }

    @Test
    public void test12() throws Exception {

        FileInputStream fis = new FileInputStream(new File("D:/abc/fpxx_0_01.xml"));
        byte[] bytes = new byte[1024];

        ByteArrayOutputStream arrayos = new ByteArrayOutputStream();
        int len;
        while ((len = fis.read(bytes)) != -1) {
            arrayos.write(bytes, 0, len);
        }
        byte[] base64 = org.apache.commons.codec.binary.Base64.encodeBase64(arrayos.toByteArray());
        arrayos.close();
        fis.close();
        String s = new String(base64, "utf-8");
        System.out.println(s);
    }


    @Test
    public void test14() throws Exception {

        int i = 1;
        System.out.println("aa第" + (i + 1) + "行");
    }

    @Test
    public void test15() throws Exception {

        String s1 = UUID.randomUUID().toString().replaceAll("-", "");
        String s2 = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(s1);
        System.out.println(s2);

    }

    @Test
    public void test13() throws Exception {

        String[] arrays = {"123", "nihao"};
        System.out.println(Arrays.toString(arrays));
        System.out.println(arrays.toString());
    }
}