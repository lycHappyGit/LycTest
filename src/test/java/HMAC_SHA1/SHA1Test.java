package HMAC_SHA1;

import org.junit.Test;

public class SHA1Test {

    /**
     * HmacSHA1 加密
     * @throws Exception
     */
    @Test
    public void test() throws Exception {

        String data = "POST/recipt/checkFp/getFPInfoByNSRSBH?authorize={\"appSecId\":\"1ff19043afdb8ac20272c2fab3304c78\"}&globalInfo={\"appId\":\"CYFP\",\"version\":\"v1.0\",\"interfaceCode\":\"CHECK.SINGLE\",\"enterpriseCode\":\"SMDGJ\",\"dataExchangeId\":\"SMDGJ20181207000000004\"}&data=eyJ0YXhObyI6IiIsImludm9pY2VUeXBlIjoiMDQiLCJpbnZvaWNlTm8iOiIzODUwMjA5MSIsImludm9pY2VDb2RlIjoiMDMyMDAxODAwMTA0IiwiaW52b2ljZURhdGUiOiIyMDE4MTExNyIsImludm9pY2VBbW91bnQiOiIiLCJjaGVja0NvZGUiOiI3MzE4OTkifQ==";
        String key = "8297b2974a9f218d9a2225f8adff8054";
        String result = HmacSHA1Util.hmacsha1(data, key);
        System.out.println(result);
    }
}

