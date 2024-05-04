package strukdat;

public class HuffmanNode extends GNode<Integer, Character>{
    TheArrayList<String> codeList;
    private char value;
    public HuffmanNode(int freq, char letter, HuffmanNode node1, HuffmanNode node2){
        super(freq,letter);
        llink = node1;
        rlink = node2;
        value = letter;
    }

    public char getValue(){
        return value;
    }

    public TheArrayList<String> getHuffmanCodes(HuffmanNode root, int n){
        String s = "";
        codeList = new TheArrayList<String>(n);
        printCode(root, s);
        return codeList;
    }

    public void printCode(HuffmanNode node, String s){
        if (node.llink == null && node.rlink == null) {
            codeList.add(node.data + " " + s);
            return;
        }
        printCode((HuffmanNode)node.llink, s+"1");
        printCode((HuffmanNode)node.rlink,s+"0");
    }

}
