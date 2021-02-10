package i.jmv.solution;

import i.jmv.solution.util.CharStack;
import org.junit.Assert;
import org.junit.Test;


/**
 * 20. 有效的括号
 */
public class Solution20 {

    @Test
    public void testIsValid() {
        Assert.assertTrue(isValid(""));
        Assert.assertFalse(isValid("[[[]]]]"));
        Assert.assertFalse(isValid("[[[[]]"));
        Assert.assertTrue(isValid("[]"));
        Assert.assertTrue(isValid("{[]}"));
        Assert.assertFalse(isValid("{[}]"));
        Assert.assertFalse(isValid("({[}])"));
        Assert.assertTrue(isValid("({[]})"));
        Assert.assertTrue(isValid("{{}[][[[]]]}"));
    }

    public boolean isValid(String s) {

        char[] chars = s.toCharArray();
        CharStack stack = new CharStack();
        for (char aChar : chars) {
            if (isLeftBrackets(aChar)) {
                stack.append(aChar);
            } else {
                if (stack.getChar() == antiBrackets(aChar))
                    stack.remove();
                else
                    stack.append(aChar);
            }
        }
        return stack.length() == 0;
    }

    private boolean isLeftBrackets(char c) {
        switch (c) {
            case '[':
            case '{':
            case '(':
                return true;
            default:
                return false;
        }
    }

    private char antiBrackets(char c) {
        switch (c) {
            case ']':
                return '[';
            case '}':
                return '{';
            case ')':
                return '(';
            default:
                return ' ';
        }
    }

}