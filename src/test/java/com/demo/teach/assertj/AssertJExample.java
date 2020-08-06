package com.demo.teach.assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.atIndex;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.util.collections.Sets;

public class AssertJExample {

    @Test
    public void testDate() {
        LocalDate localDate = LocalDate.of(2020, 2, 10);
        LocalDate beforeDate = LocalDate.of(2020, 1, 10);
        LocalDate afterDate = LocalDate.of(2020, 4, 10);

        assertThat(localDate)
                .isBefore(afterDate)
                .isAfter(beforeDate)
                .isBetween(beforeDate, afterDate);


        Assert.assertTrue(localDate.isAfter(beforeDate));
        Assert.assertTrue(localDate.isBefore(afterDate));
    }

    @Test
    public void testList() {
        List<String> list = Arrays.asList("pig", "dog", "cat");
        Set<String> set = Sets.newSet("people", "dog", "cat", "pig");
        assertThat(list)
                .contains("dog")
                .containsAnyOf("dog", "monkey", "me")
                .containsExactly("pig", "dog", "cat")
                .doesNotContain("people")
                .anyMatch(set::contains);
    }

    @Test
    public void testObjectList() {
        List<TestObject> testObjects = Arrays.asList(new TestObject("Me", "People"),
                new TestObject("You", "Reader"));

        assertThat(testObjects)
                .anyMatch(x -> x.name.equals("Me"))
                .doesNotContainNull();
    }

}

class TestObject {
    String name;
    String type;


    TestObject(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
