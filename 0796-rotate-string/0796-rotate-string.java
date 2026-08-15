class Solution {
    public boolean rotateString(String s, String goal) {
        String result = s.concat(s);

        if(s.length() != goal.length()) return false;

        return (result.contains(goal)) ? true : false;
    }
}