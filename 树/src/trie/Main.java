package trie;

public class Main {
    public static void main(String[] args) {
        Trie<Integer> integerTrie = new Trie<>();
        integerTrie.add("11",1);
        integerTrie.add("12",2);
        integerTrie.add("23",3);
        integerTrie.add("124",4);
        integerTrie.add("512",5);
        integerTrie.add("1245",6);
        System.out.println(integerTrie.startsWith("3"));
    }
}
