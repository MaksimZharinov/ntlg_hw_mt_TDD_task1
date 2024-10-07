import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PhoneBookTest {

    PhoneBook phoneBook = new PhoneBook();
    final int CHECK_NAME = -1;
    int expectedCount = 0;

    @Test
    void addTest1() throws Exception {

        var resultCount = phoneBook.add("testName", "1234567890");
        expectedCount = expectedCount + 1;

        assertEquals(expectedCount, resultCount);
    }

    @Test
    void addTest2() throws Exception {

        var resultCount = phoneBook.add("newTestName", "1234567890");
        expectedCount = expectedCount + 1;

        assertEquals(expectedCount, resultCount);
    }

    @Test
    void addTest3() throws Exception {

        phoneBook.add("testName3", "1234567890");
        expectedCount = expectedCount + 1;


        int testEntryName = phoneBook.add("testName3", "1234567890");
        expectedCount = expectedCount + 1;


        assertEquals(CHECK_NAME, testEntryName);
    }

    @Test
    void addTest4() throws Exception {

        Throwable exception = assertThrows(Exception.class, () ->
                phoneBook.add("testNumberName", "invalidNumber"));

        assertEquals("invalid number", exception.getMessage());
    }

    @Test
    void findByNumberTest() throws Exception {

        phoneBook.add("aaa", "1111111111");
        expectedCount = expectedCount + 1;
        phoneBook.add("ccc", "3333333333");
        expectedCount = expectedCount + 1;
        phoneBook.add("bbb", "2222222222");
        expectedCount = expectedCount + 1;

        var expectedName = "bbb";
        var number = "2222222222";

        var resultName = phoneBook.findByNumber(number);

        assertEquals(expectedName, resultName);
    }

    @Test
    void findByNameTest() throws Exception {

        phoneBook.add("ddd", "4444444444");
        expectedCount = expectedCount + 1;
        phoneBook.add("fff", "6666666666");
        expectedCount = expectedCount + 1;
        phoneBook.add("eee", "5555555555");
        expectedCount = expectedCount + 1;

        var expectedNumber = "6666666666";
        var name = "fff";

        var resultNumber = phoneBook.findByName(name);

        assertEquals(expectedNumber, resultNumber);
    }

    @Test
    void printAllNamesTest() throws Exception {

        phoneBook.add("ggg", "7777777777");
        expectedCount = expectedCount + 1;
        phoneBook.add("jjj", "9999999999");
        expectedCount = expectedCount + 1;
        phoneBook.add("hhh", "8888888888");
        expectedCount = expectedCount + 1;

        var expectedNames = "ggg\nhhh\njjj\n";

        var resultNames = phoneBook.printAllNames();

        assertEquals(expectedNames, resultNames);
    }
}