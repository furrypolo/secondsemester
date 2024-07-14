package datstruct.system;
import datstruct.system.patientsData;

public class TrieNode {
    TrieNode[] children;
    boolean end;
    patientsData data;

    public TrieNode() {
        this.children = new TrieNode[26]; // For each letter in the alphabet
        this.end = false; // Initially, this node does not mark the end of a word
        this.data = null;
    }
}
