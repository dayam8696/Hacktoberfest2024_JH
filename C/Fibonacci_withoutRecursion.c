#include <stdio.h>

// Function to calculate the nth Fibonacci number without recursion
int fibonacci(int n) {
    if (n <= 1)
        return n;

    int fib1 = 0, fib2 = 1, fib;
    
    for (int i = 2; i <= n; i++) {
        fib = fib1 + fib2;
        fib1 = fib2;
        fib2 = fib;
    }

    return fib2;
}

int main() {
    int n;

    printf("Enter the position of the Fibonacci sequence: ");
    scanf("%d", &n);

    printf("Fibonacci number at position %d is %d\n", n, fibonacci(n));
    return 0;
}
