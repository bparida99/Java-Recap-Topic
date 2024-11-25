package practice.example;

public class Main {

    public static void main(String[] args) {
      int[] arr = { -1,-2,-3, 1, 2,-5, 3};
      int start=0;
      int end=0;
      int max=Integer.MIN_VALUE;
      for(int i=0;i<arr.length;i++){
          int result=0;
          for(int j =0;j<arr.length-i;j++){
              result = result+arr[i+j];
              if(result>max){
                  max =result;
                  start=i;
                  end=i+j;
              }
          }
      }
    System.out.println(max);
    System.out.println(start+"   "+end);
    }
}