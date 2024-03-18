import myLinkedList.SingleList;

class MyData{
    int id;
    String name;

    MyData(int theid, String thename){
        id = theid;
        name = thename;
    }

    @Override
    public String toString(){
        return (Integer.toString(id) + ": " + name + " ");
    }
}

public class MainProgram {
    public static void main(String[] args) throws Exception {
        SingleList<MyData> List3 = new SingleList<>();
        MyData data1 = new MyData(1, "Hans");
        MyData data2 = new MyData(2, "Fernando");
        MyData data3 = new MyData(3, "Collab");
        List3.pushS(data1);
        List3.pushS(data2);
        List3.pushS(data3);
        List3.cetakList();
        // if(List3.remove(data2)) System.out.println("Berhasil");
        // List3.cetakList();

        // SingleList<Character> List2 = new SingleList<>();
        // List2.pushS('a');
        // List2.pushS('b');
        // List2.pushS('c');
        // String out;
        // while(!List2.isEmpty()){
        //     out=List2.remove().toString();
        //     System.out.print(out);
        // }
        // System.out.println();
    }
}