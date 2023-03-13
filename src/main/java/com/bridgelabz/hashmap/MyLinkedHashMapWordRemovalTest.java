package com.bridgelabz.hashmap;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedHashMapWordRemovalTest {
    @Test
    public void GivenSentenceWhenWordsAreAddedToListShouldRemoveGivenWord() {
        String sentence = "Paranoids are not paranoid because they are paranoid but because" +
                "they keep putting themselves deliberately into paranoid avoidable situations";
        MyLinkedHashMapWordRemoval<String, Integer> myLinkedHashMapWordRemoval = new MyLinkedHashMapWordRemoval<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = myLinkedHashMapWordRemoval.get(word);
            if (value == null) value = 1;
            else value = value +1;
            myLinkedHashMapWordRemoval.add(word, value);
        }
        myLinkedHashMapWordRemoval.remove("avoidable");
        System.out.println(myLinkedHashMapWordRemoval);
        int frequency = myLinkedHashMapWordRemoval.get("avoidable");
        Assert.assertEquals(0, frequency);
    }
}
