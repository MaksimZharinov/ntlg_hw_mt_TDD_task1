import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhoneBookTest {

    PhoneBook phoneBook = new PhoneBook();

    @Test
    void addTest() {

        int resultCount;
        int expectedCount = 0;
        final int CHECK_NAME = -1;

        try {
            resultCount = phoneBook.add("testName", "1234567890");
            expectedCount = expectedCount + 1;

            assertEquals(expectedCount, resultCount);
        } catch (Exception t1) {
            System.out.println("testAddFirst_err");
        }

        try {
            resultCount = phoneBook.add("newTestName", "1234567890");
            expectedCount = expectedCount + 1;

            assertEquals(expectedCount, resultCount);
        } catch (Exception t2) {
            System.out.println("testAddNext_err");
        }

        try {
            int testEntryName = phoneBook.add("testName", "1234567890");

            assertEquals(CHECK_NAME, testEntryName);
        } catch (Exception t3) {
            System.out.println("testName_err");
        }

        try {
            phoneBook.add("testNumberName", "invalidNumber");
        } catch (Exception e) {
            assertEquals("invalid number", e.getMessage());
        }
    }

    @Test
    void findByNumberTest() {

        try {
            phoneBook.add("aaa", "1111111111");
            phoneBook.add("ccc", "3333333333");
            phoneBook.add("bbb", "2222222222");
        } catch (Exception e) {
            e.getStackTrace();
        }
        var expectedName = "bbb";
        var number = "2222222222";

        var resultName = phoneBook.findByNumber(number);

        assertEquals(expectedName, resultName);
    }

    @Test
    void findByNameTest() {

        try {
            phoneBook.add("ddd", "4444444444");
            phoneBook.add("fff", "6666666666");
            phoneBook.add("eee", "5555555555");
        } catch (Exception e) {
            e.getStackTrace();
        }

        var expectedNumber = "6666666666";
        var name = "fff";

        var resultNumber = phoneBook.findByName(name);

        assertEquals(expectedNumber, resultNumber);
    }

    @Test
    void printAllNamesTest() {

        try {
            phoneBook.add("ggg", "7777777777");
            phoneBook.add("jjj", "9999999999");
            phoneBook.add("hhh", "8888888888");
        } catch (Exception e) {
            e.getStackTrace();
        }
        var expectedNames = "ggg\nhhh\njjj\n";

        var resultNames = phoneBook.printAllNames();

        assertEquals(expectedNames, resultNames);
    }
}