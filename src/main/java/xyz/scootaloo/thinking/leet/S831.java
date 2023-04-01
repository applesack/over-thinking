package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/04/01
 */
public class S831 {

    public String maskPII(String s) {
        String lower = s.toLowerCase();
        int idx = lower.indexOf('@');
        if (idx >= 0) {
            return encodeEmail(lower, idx);
        }
        return encodePhone(lower);
    }

    private String encodeEmail(String input, int idx) {
        String mask = "*****";
        String username = input.substring(0, idx);
        String postfix = input.substring(idx);
        if (username.length() == 1) {
            return username + mask + postfix;
        }
        return username.charAt(0) + mask + username.charAt(username.length() - 1) + postfix;
    }

    private String encodePhone(String input) {
        StringBuilder builder = new StringBuilder(input.length());
        for (int i = 0, len = input.length(); i < len; i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                builder.append(ch);
            }
        }
        int len = builder.length();
        StringBuilder result = new StringBuilder(len + 4);
        String seg1 = "**-";
        String seg2 = "***-";
        String countryCode = "";
        if (len > 10) {
            if (len == 11) {
                countryCode = "+*-";
            } else if (len == 12) {
                countryCode = "+" + seg1;
            } else {
                countryCode = "+" + seg2;
            }
        }

        result.append(countryCode);
        result.append(seg2);
        result.append(seg2);
        result.append(builder.substring(len - 4));
        return result.toString();
    }

}
