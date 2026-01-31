package com.example.junit_practice;



import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ListManagerTest {

    ListManager manager = new ListManager();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();

        manager.addElement(list, 10);
        manager.addElement(list, 20);

        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);

        manager.removeElement(list, 10);

        assertFalse(list.contains(10));
        assertTrue(list.contains(20));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();

        manager.addElement(list, 1);
        manager.addElement(list, 2);
        manager.addElement(list, 3);

        assertEquals(3, manager.getSize(list));

        manager.removeElement(list, 2);
        assertEquals(2, manager.getSize(list));
    }
}

