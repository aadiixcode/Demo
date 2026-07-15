class Solution {
    static int gcd(int a,int b){
        while(a>0 && b>0){
            if(a>b) a=a%b;
            else b=b%a;
        }
        if(a==0) return b;
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0, sumEven = 0;
        int num = 1;
        n=2*n;

        while (n != 0) {
            if (num % 2 == 0) {
                sumEven += num;
            } else {
                sumOdd += num;
            }
            n-=1;
            num+=1;
        }

        System.out.println(sumOdd);
        System.out.println(sumEven);
        return gcd(sumOdd,sumEven);
    }
}