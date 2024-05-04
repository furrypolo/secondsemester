public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] array = {1, 2, 3, 4, 5, 6};
        method2(array, 6);
    }

    public static void method2(int[] array, int n){
        int index;
        for (index = 1; index <= n-1; index++){
            privateMethod2 (array [index], array, 0, index - 1);
        }

    } // end method2

    public static void privateMethod2(int entry, int[] array, int begin, int end) {

        int index; 
        for (index=end; (index > begin) && (entry < array[index]); index--){
            array [index + 1] = array[index];
        }

        array [index + 1] = entry;
        System.out.print(array);
    }

}
