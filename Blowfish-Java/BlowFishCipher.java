class BlowFishCipher{

     public static int minimal(int input1, int[] input2) {
          int sum = 0;
          for (int i = 0; i < input1; i++) {
               for (int j = i + 1; j < input1; j++) {
                    if (input2[i] == input2[j]) {
                         int[] count = new int[] { input2[i] };
                         input2[i] = input2[i] + count[0];
                    }
               }
          }

          for (int i = 0; i < input1; i++) {
               sum = sum + input2[i];
          }
          return sum;
     }

     public static void main(String[] args) throws Exception {
          int n = 5;
          int[] arr = new int[] { 1, 4, 5, 4, 5 };
          int result = minimal(n, arr);
          System.out.println(result);
     }
}
