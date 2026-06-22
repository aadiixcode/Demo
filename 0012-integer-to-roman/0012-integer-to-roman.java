class Solution {
    public String intToRoman(int n) {
        String[] arr = new String[1000+1];
        arr[1] = "I";
        arr[4] = "IV";
        arr[5] = "V";
        arr[9] = "IX";
        arr[10] = "X";
        arr[40] = "XL";
        arr[50] = "L";
        arr[90] = "XC";
        arr[100] = "C";
        arr[400] = "CD";
        arr[500] = "D";
        arr[900] = "CM";
        arr[1000] = "M";
        
        int digit = (int) Math.log10(n);
        int power = (int) Math.pow(10,digit);
        StringBuilder sb = new StringBuilder();

        while(n>0){
            int q = n/power;
            if(q==4 || q==9){
                sb.append(arr[q*power]);
            }
            else if(q<4){
                while(q>0){
                    sb.append(arr[power]);
                    q-=1;
                }
            }
            else if(q>=5){
                sb.append(arr[5*power]);
                while(q>5){
                    sb.append(arr[power]);
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