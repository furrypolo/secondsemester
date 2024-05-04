import strukdat.HuffmanNode;
import strukdat.Heap;
import strukdat.TheArrayList;

public class HuffmanCoding {
    public static void main(String[] args) {
        char[] charArray = {'E', 'T', 'N', 'I', 'S'};
        int[] charfreq = {29, 10, 9, 5, 4};

        Heap<Integer, HuffmanNode> pq = new Heap<>(charArray.length, true);
        int i;
        for ( i=0; i<charArray.length; i++) {
            pq.add(charfreq[i], new HuffmanNode(charfreq[i], charArray[i], null, null));
            pq.sort();
        }

        pq.buildHeap();
        pq.display();

        HuffmanNode root = buildHuffmanTree(pq);
        System.out.println();

        TheArrayList<String> fin;
        fin = root.getHuffmanCodes(root, charArray.length);
        fin.cetakList();

        System.out.println("---------------------");
        System.out.println(" Huruf | Huffman code ");
        System.out.println("---------------------");
        for ( i = 0; i < charArray.length; i++) {
            String[] letter_code = fin.get(i).split("\\s+");
            System.out.println(" " + letter_code[0] + "     |  " + letter_code[1]);
        }
        System.out.println("---------------------");
    }

    static HuffmanNode buildHuffmanTree(Heap<Integer, HuffmanNode> pq) {
        HuffmanNode root = null;
        HuffmanNode x, y;
        int sum;
        while (pq.size() > 1) {
            sum = pq.getKey(pq.first());
            x = pq.getData(pq.first());
            pq.removeFirst();
            sum += pq.getKey(pq.first());
            y = pq.getData(pq.first());
            pq.removeFirst();
            root = new HuffmanNode(sum, '-', x, y);
            pq.insert(sum, root);
            pq.display();
        }
        return root;
    }
}