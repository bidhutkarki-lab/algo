package algo.addString;

/**
 * Leetcode 415. Add Strings with decimal variant
 */
public class AddStringWithDecimal {

    public String addDecimalStrings(String num1, String num2) {
        String[] parts1 = num1.split("\\.");
        String[] parts2 = num2.split("\\.");

        String int1 = parts1[0];
        String int2 = parts2[0];
        String frac1 = parts1.length > 1 ? parts1[1] : "";
        String frac2 = parts2.length > 1 ? parts2[1] : "";

        int fracLength = Math.max(frac1.length(), frac2.length());
        frac1 = padRight(frac1, fracLength);
        frac2 = padRight(frac2, fracLength);

        // Add fractional part
        String fracSum = addStrings(frac1, frac2, 0);

        String extraCarry = "";
        if (fracSum.length() > fracLength) {
            extraCarry = fracSum.substring(0, fracSum.length() - fracLength);
            fracSum = fracSum.substring(fracSum.length() - fracLength);
        }

        // Add integer part with overflow from fractional
        String intSum = addStrings(int1, int2, Integer.parseInt(extraCarry));

        return fracLength > 0 ? intSum + "." + fracSum : intSum;
    }

    private String addStrings(String num1, String num2, int carry) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = n1 + n2 + carry;

            result.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }

        return result.reverse().toString();
    }

    private String padRight(String s, int length) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < length) sb.append("0");
        return sb.toString();
    }


    public static void main(String[] args) {
        AddStringWithDecimal solution = new AddStringWithDecimal();

        System.out.println(solution.addDecimalStrings("123.45", "678.9"));      // 802.35
        System.out.println(solution.addDecimalStrings("1.99", "2.02"));         // 4.01
        System.out.println(solution.addDecimalStrings("99.999", "0.002"));      // 100.001
        System.out.println(solution.addDecimalStrings("1", "2.5"));             // 3.5
        System.out.println(solution.addDecimalStrings("100", "900"));           // 1000
    }
}
