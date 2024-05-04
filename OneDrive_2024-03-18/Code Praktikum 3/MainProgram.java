/*
 * Test generic SingleList.java
 * 
 * @author: Lely Hiryanto
 */
import mylinkedlist.SingleList;

class MyData {
    int id;
    String name;

    MyData(int theid, String thename) {
        id = theid;
        name = thename;
    }
    @Override
    public String toString() {
        return (Integer.toString(id) + ": " + name + " ");
    }
}

public class MainProgram {    
    public static void main(String[] args) {
        //PR Praktikum 3a: no 1b queue (fungsi untuk menyelesaikan ada di file SingleList.java)
        SingleList<Integer> carQ = new SingleList<>();
        carQ.pushQ(1);
        carQ.pushQ(4);
        carQ.pushQ(6);
        carQ.pushQ(9);
        carQ.pushQ(10);
        carQ.pushQ(14);
        carQ.pushQ(25);
        carQ.pushQ(27);
        carQ.pushQ(30);
        carQ.pushQ(38);
        carQ.pushQ(40);
        carQ.pushQ(47);
        carQ.pushQ(55);
        carQ.pushQ(58);
        carQ.pushQ(62);
        carQ.pushQ(999);
        
        carQ.averageWait(7.0, 12.0);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        //PR Praktikum 3b: no 1 Stack
        String postfix1 = infixToPostfix("(a+b*(c/(d-e)))+f/g");
        System.out.println("a. (a+b*(c/(d-e)))+f/g =>" + postfix1);
        String postfix2 = infixToPostfix("(a+b-c)*(d-e/(f+g))");
        System.out.println("b. (a+b-c)*(d-e/(f+g)) =>" + postfix2);
        String postfix3 = infixToPostfix("a-b*(c+d)/(e-f)+g");
        System.out.println("c. a-b*(c+d)/(e-f)+g =>" + postfix3);
        String postfix4 = infixToPostfix("a*(b-c)+d^e/f*g");
        System.out.println("d. a*(b-c)+d^e/f*g =>" + postfix4);
    }

    //fungsi untuk menyelesaikan PR Praktikum 3b: no 1 Stack (infix to postfix) (Ditambah fungsi getHead() pada file SingleList.java)
    public static String infixToPostfix(String infix){
        SingleList<Character> operate = new SingleList<>();
        String result="";
        Character operator=' ';
        Character temp= null;
        int round = 0;
        for (char inf : infix.toCharArray()){
            if(Character.isAlphabetic(inf) || Character.isDigit(inf)){
                round += 1;
                result = result + String.valueOf(inf);
                if(round == 2){
                    operator = operate.getHead();
                    if(operator=='/' || operator=='*' || operator == '^'){
                        result = result + operator;
                        round=1;
                    }
                    else{
                        temp = operator;
                    }
                }
            }
            else{
                if(inf != '(' && inf != ')'){  
                    if(temp == null){
                        operate.pushS(inf);
                    }
                    else{
                        if(inf == '/' || inf == '*' || inf == '^'){
                            operate.pushS(temp);
                            temp = null;
                            operate.pushS(inf);
                        }
                        else{
                            result = result + temp;
                            temp = null;
                            round=0;
                            operate.pushS(inf);
                        }
                    }
                }
                if(inf == ')'){
                    operator = operate.getHead();
                    do{ 
                        if(temp!=null){
                            result = result + temp;
                            temp = null;
                        }
                        else{
                            result = result + operator;
                            operator = operate.getHead();
                        }
                    }while(operator!='(');

                    char check;

                    if(!operate.isEmpty()){
                        operator = operate.getHead();
                        check = operator;
                        if(!operate.isEmpty()){
                            operator = operate.getHead();
                            if(operator!='('){
                                result = result + check;
                                operate.pushS(operator);
                            }
                            else{
                                operate.pushS(operator);
                                operate.pushS(check);
                            }   
                        }
                        else{
                            result = result + check;
                        }
                    }
                    round=0;

                }
                if(inf == '('){
                    operate.pushS(inf);
                    round=0;
                }
            }
        }

        if(!(operate.isEmpty())){
            char[] operArray = new char[10];
            operArray[0] = '0';
            int num1=1;
            char[] newPos = new char[10];
            newPos[0] = '0';
            while(!(operate.isEmpty())){
                operator = operate.getHead();
                operArray[num1] = operator;
                num1++;
            }
            int x;
            for(x=1; x<num1; x++){
                result = result + operArray[x];
            }
        }

        return result;
    }
    


        // //buat object 'List' dari class SingleList untuk data Integer
		// SingleList<Integer> List1 = new SingleList<>();
        // List1.pushQ(10);
        // List1.pushQ(20);
        // List1.pushQ(30);
        // List1.cetakList();

        // //buat object 'List2' dari class SingleList untuk data character
        // SingleList<Character> List2 = new SingleList<>();
        // List2.pushS('a');
        // List2.pushS('b');
        // List2.pushS('c');
        // String out;
        // while( !List2.isEmpty()) {
        //     out = List2.remove().toString();
        //     System.out.print(out);
        // }
        // System.out.println();

        // //buat object 'List3' dari class SingleList untuk'
        // //object dari class MyData
        // SingleList<MyData> List3 = new SingleList<>();
        // MyData data1 = new MyData(1, "Hans");
        // MyData data2 = new MyData(2, "Fernando");
        // MyData data3 = new MyData(3, "Collab");
        // List3.pushS(data1);
        // List3.pushS(data2);
        // List3.pushS(data3);
        // List3.cetakList();
        // if(List3.remove(data2)) System.out.println("Berhasil!");
        // List3.cetakList();
}
