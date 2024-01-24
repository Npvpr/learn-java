package returntest;

public class ReturnTest {
    public static void main(String[] args) {
        for(int i = 0; i < 6; i++){
            System.out.println(i + " In 1");
            for(int j = i; j < 6; j++){
                System.out.println(j + " In 2");
                if(j == 2){
                    // break will exit the loop
                    break;
                }
                if(j == 4){
                    // return will terminate the whole function
                    return;
                }
            }
            System.out.println("-----");
        }
    }
}
