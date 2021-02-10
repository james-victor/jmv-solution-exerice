package i.jmv.solution.util;


public class CharStack {

    private StringBuilder sb = new StringBuilder();

    public void append(char c) {
        sb.append(c);
    }

    public void remove() {
        if (sb.length() != 0)
            sb.deleteCharAt(sb.length() - 1);
    }

    public char getChar() {
        return sb.length() != 0 ? sb.charAt(sb.length() - 1) : ' ';
    }

    public int length() {
        return sb.length();
    }

}