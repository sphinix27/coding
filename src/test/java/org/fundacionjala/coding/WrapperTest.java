package org.fundacionjala.coding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WrapperTest {

    @Test
    public void test1() {
        final String sentences = "Lorem ipsum dolor sit amet, consectetur adipisicing elit";
        String expected = "Lorem ipsum\n" +
                          "dolor sit amet,\n" +
                          "consectetur\n" +
                          "adipisicing\n" +
                          "elit";
        assertEquals(expected, Wrapper.wrap(sentences, 15));
    }

}
