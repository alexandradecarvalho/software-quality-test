package tqs.lab1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TqsStackTest {

    private TqsStack<String> newStack;
    private TqsStack<String> stack3elems;

    @BeforeEach
    void setUp() {
        newStack = new TqsStack<>();

        stack3elems = new TqsStack<>();
        stack3elems.push("Aveiro");
        stack3elems.push("Coimbra");
        stack3elems.push("Porto");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("a) A stack is empty on construction")
    void isEmptyOnConstruction() {
        assertTrue(newStack.isEmpty(), "The stack is not empty at the time of its construction.");
    }

    @Test
    @DisplayName("b) A stack has size 0 on construction")
    void sizeZeroOnConstruction() {
        assertEquals(0,newStack.size(),"The stack's size is not 0 at the time of its construction.");
    }

    @Test
    @DisplayName("c) After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    void nPushesToEmptyStack() {
        assertEquals(3, stack3elems.size(), "After three pushes, expected stack's size is 3 and the given size is " + stack3elems.size());
    }

    @Test
    @DisplayName("d) If one pushes x then pops, the value popped is x.")
    void poppedIsJustPushed() {
        stack3elems.push("Lisboa");
        String value = stack3elems.pop();
        assertEquals("Lisboa",value,"After a push, expected pop value is Lisboa and the given value is " + value);
    }

    @Test
    @DisplayName("e) If one pushes x then peeks, the value returned is x, but the size stays the same")
    void peek() {
        String pushed = "Lisboa";
        stack3elems.push(pushed);
        int s1 = stack3elems.size();
        String value = stack3elems.peek();
        int s2 = stack3elems.size();
        assertEquals(pushed, value, "After a push, expected peek value is " + pushed + " and the given value is " + value);
        assertEquals(s1, stack3elems.size(), "After a push, stack's expected size should be " + s1 + " and the given value is " + value);
    }

    @Test
    @DisplayName("f) If the size is n, then after n pops, the stack is empty and has a size 0")
    void nPushedToPopulatedStack(){
        stack3elems.pop();
        stack3elems.pop();
        stack3elems.pop();

        assertTrue(stack3elems.isEmpty(),"After 3 pops, stack should be empty, but isn't");
        int s = stack3elems.size();
        assertEquals(0, s, "After 3 pops, stack should have size 0, but has size " + s + " instead");
    }

    @Test
    @DisplayName("g) Popping from an empty stack does throw a NoSuchElementException")
    void poppedException(){
        assertThrows(NoSuchElementException.class, () -> {newStack.pop();}, "Popping from an empty stack did not throw a NoSuchElementException");
    }

    @Test
    @DisplayName("h) Peeking into an empty stack does throw a NoSuchElementException")
    void peekedException(){
        assertThrows(NoSuchElementException.class, () -> {newStack.peek();}, "Peeking into an empty stack did not throw a NoSuchElementException");
    }

    @Test
    @DisplayName("i) For bounded stacks only, pushing onto a full stack does throw an IllegalStateException")
    void pushedException(){
        stack3elems.push("Lisboa");
        stack3elems.push("Faro");
        System.out.println(stack3elems.size());
        assertThrows(IllegalStateException.class, () -> {stack3elems.push("Almada");}, "Pushing onto a full stack (5 elements) did not throw an IllegalStateException");
    }
}