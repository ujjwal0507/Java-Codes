import java.io.*;
import java.lang.*;
import java.util.*;

public class Tries{
    public static void main(String[] args) {
        List<String> set = new ArrayList<>();

        set.add("pqrs");
        set.add("pprt");
        set.add("psst");
        set.add("qqrs");
        set.add("pqrs");

        
        Trie trie = new Trie();

        trie.insert("pqrs");
        trie.insert("psst");
        trie.insert("pprt");
        trie.insert("pqrs");
        trie.insert("pqr");
        System.out.println(trie.find("pqrs"));
        System.out.println(trie.find("str"));
        System.out.println(trie.find("pqrs"));
        trie.delete("pqrs");
        System.out.println(trie.find("pqrs"));
        trie.delete("pqr");
        System.out.println(trie.find("pqr"));
        System.out.println(trie.find("pqrs"));

    }
}

class Trie{
    final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String str){
        this.insert(root, str, 0);
    }

    public boolean find(String str){
        return this.find(root, str, 0);
    }

    public void delete(String str){
        this.delete(root, str, 0);
    }

    public void insert(TrieNode current, String str, int index){
        if(index==str.length()){
            current.terminateCount++;
            return;
        }
        char ch = str.charAt(index);
        if(!current.hasChild(ch)){
            current.addChild(ch);
        }
        insert(current.getChild(ch), str, index+1);
    }

    public boolean find(TrieNode current, String str, int index){
        if(index==str.length()){
            return current.terminateCount>0;
        }
        char ch = str.charAt(index);
        if(current.hasChild(ch)){
            return find(current.getChild(ch), str, index+1);
        }
        return false;
    }

    public void delete(TrieNode root, String str, int index){
        if(index==str.length()){
            root.terminateCount--;
            return;
        }
        
        char ch = str.charAt(index);
        if(root.hasChild(ch)){
            delete(root.getChild(ch), str, index+1);
        }
    }
    
}

class TrieNode{
    int terminateCount;
    Map<Character, TrieNode> children;

    public TrieNode(){
        this.terminateCount = 0;
        this.children = new HashMap<>();
    }

    public boolean hasChild(char ch){
        return this.children.containsKey(ch);
    }

    public TrieNode getChild(char ch){
        return this.children.get(ch);
    }

    public void addChild(char ch){
        this.children.put(ch, new TrieNode());
    }
}