class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        String resultS = new String(sArray);
        String resultT = new String(tArray);

        return (resultS.equals(resultT)) ? true : false;
        
    }
}