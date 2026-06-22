class Solution {
    public String intToRoman(int n) {
        Map<Integer,String> mp = new HashMap<>();
        mp.put(1,"I");
        mp.put(4,"IV");
        mp.put(5,"V");
        mp.put(9,"IX");
        mp.put(10,"X");
        mp.put(40,"XL");
        mp.put(50,"L");
        mp.put(90,"XC");
        mp.put(100,"C");
        mp.put(400,"CD");
        mp.put(500,"D");
        mp.put(900,"CM");
        mp.put(1000,"M");

        int digit = (int) Math.log10(n);
        int power = (int) Math.pow(10,digit);
        StringBuilder sb = new StringBuilder();

        while(n>0){
            int q = n/power;
            if(q==4 || q==9){
                sb.append(mp.get(q*power));
            }
            else if(q<4){
                while(q>0){
                    sb.append(mp.get(power));
                    q-=1;
                }
            }
            else if(q>=5){
                sb.append(mp.get(5*power));
                while(q>5){
                    sb.append(mp.get(power));
                    q-=1;
                }
            }
            System.out.println(sb);
            n=n%power;
            power/=10;
        }
        return sb.toString();
    }
}