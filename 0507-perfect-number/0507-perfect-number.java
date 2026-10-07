class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 1;

        if(num == 1) {
            return false;
        }

        int i = 2;

        while(i * i < num){
            if(num % i == 0) {
                sum += i;
                sum += num/i;
            }
            i++;
        }

        return sum == num;
    }
}