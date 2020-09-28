package util;

public class IpUtil {
    /**  
     * 判断IP是否在指定范围；  
     */  
        
    public static boolean ipIsValid(String ipSection, String ip) {   
        if (ipSection == null)   
            throw new NullPointerException("IP段不能为空！");   
        if (ip == null)   
            throw new NullPointerException("IP不能为空！");   
        ipSection = ipSection.trim();   
        ip = ip.trim();   
        final String REGX_IP = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";   
        final String REGX_IPB = REGX_IP + "\\-" + REGX_IP;   
        if (!ipSection.matches(REGX_IPB) || !ip.matches(REGX_IP))   
            return false;   
        int idx = ipSection.indexOf('-');   
        String[] sips = ipSection.substring(0, idx).split("\\.");   
        String[] sipe = ipSection.substring(idx + 1).split("\\.");   
        String[] sipt = ip.split("\\.");   
        long ips = 0L, ipe = 0L, ipt = 0L;   
        for (int i = 0; i < 4; ++i) {   
            ips = ips << 8 | Integer.parseInt(sips[i]);   
            ipe = ipe << 8 | Integer.parseInt(sipe[i]);   
            ipt = ipt << 8 | Integer.parseInt(sipt[i]);   
        }   
        if (ips > ipe) {   
            long t = ips;   
            ips = ipe;   
            ipe = t;   
        }   
        return ips <= ipt && ipt <= ipe;   
    }

    public static void main(String[] args) {   
        if (ipIsValid("192.168.1.1-192.168.5.10", "192.168.5.127")) {
            System.out.println("ip属于该网段true");
        } else
            System.out.println("ip不属于该网段false");
    }   
} 