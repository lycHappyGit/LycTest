package signTest;

import java.util.TreeMap;

public class SignTest {

    public static void main(String[] args) throws Exception {

        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put(SignConstance.content, "eyJGUEtKWFhfRERYWCI6eyJERERBVEUiOiIyMDE4LTA5LTI1IDEzOjQzOjU2IiwiRERIIjoiMDAxMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAyNzkifSwiRlBLSlhYX0ZQVFhYIjp7IkJNQl9CQkgiOiIxMy4wIiwiQloiOiJoYWhoc2hhZmFzIiwiQ1pETSI6IjEwIiwiREtCWiI6IjAiLCJEU1BUQk0iOiIxNDRUVkNDTiIsIkZQUVFMU0giOiIxNDRUVkNDTjA5MjUwMDAwMDEzNiIsIkZQWkxfRE0iOiI1MSIsIkdIRk1DIjoi5YyX5Lqs5Lit6LWE5Y6a5b635oqV6LWE5Z+66YeR566h55CG5pyJ6ZmQ5YWs5Y+4IiwiR0hGUVlMWCI6IjAxIiwiR0hGX0VNQUlMIjoiMzY5MDg5NDIyQHFxLmNvbSIsIkdIRl9OU1JTQkgiOiI5MTExMDEwNTU3NTE2ODk4WDIiLCJHSEZfWUhaSCI6IuWMl+S6rOmTtuihjDEyMzM0MzQ1IiwiSEpCSFNKRSI6IjAiLCJISlNFIjoiMCIsIktQTFgiOiIxIiwiS1BSUSI6IjIwMTgtMDktMjUgMTM6NDM6NTYiLCJLUFhNIjoiKuS/oeaBr+aKgOacr+acjeWKoSrnvZHnu5zmi5vogZjotLkiLCJLUFkiOiLlvKDkuIkiLCJOU1JNQyI6IjE1MDAwMTIwMzkwOTI0ODAzMiIsIk5TUlNCSCI6IjE1MDAwMTIwMzkwOTI0ODAzMiIsIlBZRE0iOiIwMDAwMDEiLCJRRF9CWiI6IjAiLCJYSEZNQyI6IuWMl+S6rOWNjuWTgeWNmuedv+enkeaKgOaciemZkOWFrOWPuCIsIlhIRl9ESCI6IjEzMzQ1Nzc3ODg4OSIsIlhIRl9EWiI6IuWMl+S6rOW4giIsIlhIRl9OU1JTQkgiOiIxNTAwMDEyMDM5MDkyNDgwMzIiLCJYSEZfWUhaSCI6IuS4reWbvemTtuihjDYyMjI4Nzg4ODk5OTgwMDAwMCJ9LCJGUEtKWFhfWE1YWFMiOlt7IkZQSFhaIjoiMCIsIkhTQloiOiIwIiwiU0wiOiIwLjA2IiwiU1BCTSI6IjEwMTAxMDEwMzAwMDAwMDAwMDAiLCJYTURKIjoiNi4wMCIsIlhNSkUiOiI2LjAwIiwiWE1NQyI6Iirkv6Hmga/mioDmnK/mnI3liqEq572R57uc5oub6IGY6LS5IiwiWE1TTCI6IjEiLCJZSFpDQlMiOiIwIn1dfQ==");
        map.put(SignConstance.encryptCode, "0");
        map.put(SignConstance.Nonce, "7000");
        map.put(SignConstance.SecretId, "289efb7512e54146273b982456b03f42ea93");
        map.put(SignConstance.Timestamp, "1537854240209");
        map.put(SignConstance.zipCode, "0");

        String signUrl = "POST103.237.2.58/invoice/v1/?";

        String signStr = HmacSHA1Util.genSign(signUrl, map, "27a06832a2214a4fa3b7105e4a72d370");
        System.out.println("signstr为: " + signStr);
    }
}
