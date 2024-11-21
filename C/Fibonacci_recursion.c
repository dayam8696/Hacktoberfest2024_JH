#include <stdio.h>

// Function to calculate the nth Fibonacci number using recursion
int fibonacci(int n) {
    if (n <= 1)
        return n;
    else
        return fibonacci(n - 1) + fibonacci(n - 2);
}

int main() {
    int n;

    printf("Enter the position of the Fibonacci sequence: ");
    scanf("%d", &n);

    printf("Fibonacci number at position %d is %d\n", n, fibonacci(n));
    return 0;
}
