package week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibTest() {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(0));
        System.out.println(fibonacci.fib(1));
        System.out.println(fibonacci.fib(2));
        System.out.println(fibonacci.fib(3));
        System.out.println(fibonacci.fib(5));
    }

    @Test
    void fibTest2() {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibRecurz(0));
        System.out.println(fibonacci.fibRecurz(1));
        System.out.println(fibonacci.fibRecurz(2));
        System.out.println(fibonacci.fibRecurz(3));
        System.out.println(fibonacci.fibRecurz(5));
    }
}