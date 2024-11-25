package practice.example;

public class ReverseInteger{

    public static int reverse(int x) {
        int max = (2^31);
        int min = -2^31;
        System.out.println(max+" "+min);
        int rev =0;
        while(x != 0){
            int carrier = x%10;
            if(rev > max ){
                return 0;
            }
            if(rev < min ){
                return 0;
            }
            rev = (rev*10)+carrier;
            x = x/10;
        }

        return rev;
    }

    public static void main(String[] args) throws Exception{
        int x = -2147483412;
        int rev = reverse(x);
        System.out.println("Reversed Integer: " + rev);
    }
}
