package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;


/**
 * 12. 整数转罗马数字
 */
public class Solution12 {

    @Test
    public void testIntToRoman() {
        Assert.assertEquals("MM", intToRoman(2000));
    }

    private String getRomaTxt(int ch, int time) {
        int num = ch * time;
        if (time == 1000) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ch; i++) {
                sb.append("M");
            }
            return sb.toString();
        }
        switch (num) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 20:
                return "XX";
            case 30:
                return "XXX";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 60:
                return "LX";
            case 70:
                return "LXX";
            case 80:
                return "LXXX";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 200:
                return "CC";
            case 300:
                return "CCC";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 600:
                return "DC";
            case 700:
                return "DCC";
            case 800:
                return "DCCC";
            case 900:
                return "CM";
            case 1000:
                return "M";
        }
        return "";
    }

    public String intToRoman(int num) {
        int time = 1;
        int n = num;
        StringBuilder rs = new StringBuilder();
        while (n > 0) {
            rs.insert(0, getRomaTxt(num % 10, time));
            num = num / 10;
            time = time * 10;
            n = n / 10;
        }
        return rs.toString();
    }
}