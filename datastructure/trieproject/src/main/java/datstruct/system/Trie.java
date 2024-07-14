package datstruct.system;
import datstruct.system.patientsData;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode(); // root is empty
    }

    public void insert(String name, patientsData data) {
        TrieNode current = root;
        for (char c : name.toLowerCase().toCharArray()) {
            if (c < 'a' || c > 'z') {
                continue; // Skip non-alphabetic characters
            }
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.end = true;
        current.data = data;
    }

    public void printTrie() {
        printIt(root, "");
    }

    private void printIt(TrieNode node, String back) {
        if (node == null) {
            return;
        }

        if (node.end) {
            System.out.println(back + " : \n" + node.data);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (node.children[c - 'a'] != null) {
                printIt(node.children[c - 'a'], back + c);
            }
        }
    }

    public boolean search(String name){
        TrieNode current = root;
        for (char c : name.toLowerCase().toCharArray()) {
            if (c < 'a' || c > 'z') {
                continue;
            }
            if(current.children[c-'a'] == null){
                return false;
            }
            current = current.children[c-'a'];
        }

        return current.end;
    }

    public void display(String name){
        TrieNode current = root;
        for (char c : name.toLowerCase().toCharArray()) {
            if (c < 'a' || c > 'z') {
                continue;
            }
            if(current.children[c-'a'] == null){
                System.out.println("Patient not found!");
            }
            current = current.children[c-'a'];
        }

        System.out.println("nama = " + name + "\n" + current.data);
    }

    public patientsData get(String name){
        TrieNode current = root;
        for (char c : name.toLowerCase().toCharArray()) {
            if (c < 'a' || c > 'z') {
                continue;
            }
            if(current.children[c-'a'] == null){
                System.out.println("Patient not found!");
            }
            current = current.children[c-'a'];
        }

        return current.data;
    }
}
