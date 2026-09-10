package com.company.google;

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    Map<String, Integer>sentenceCount;
    TrieNode() {
        children = new HashMap<>();
        sentenceCount = new HashMap<>();
    }
}
class AutocompleteSystem {

    TrieNode root;
    StringBuilder curSentence;
    TrieNode curNode;
    TrieNode dead;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        curSentence = new StringBuilder();
        curNode = root;
        dead = new TrieNode();
        for(int i=0;i<sentences.length;i++) {
            addToTrie(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if(c == '#'){
            addToTrie(curSentence.toString(), 1);
            curSentence = new StringBuilder();
            curNode = root;
            return new ArrayList<>();
        }
        curSentence.append(c);
        TrieNode node = curNode.children.get(c);
        if(node == null){
            curNode = dead;
            return new ArrayList<>();
        }
        List<String> sentences = new ArrayList<>(curNode.sentenceCount.keySet());
        sentences.sort((a, b) -> {
            int hotA = curNode.sentenceCount.get(a);
            int hotB = curNode.sentenceCount.get(b);
            if (hotA == hotB) {
                return a.compareTo(b);
            }
            return hotB - hotA;
        });
        List<String>result = new ArrayList<>();
        for(int i=0;i<Math.min(3, sentences.size());i++) {
            result.add(sentences.get(i));
        }
        return result;
    }

    private void addToTrie(String sentence, int count) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            if(!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            node.sentenceCount.put(sentence, node.sentenceCount.getOrDefault(sentence, 0) + count);
        }
    }
}
