// Package sort implements various sorting algorithms.
package sort

import (
	"strconv"
)

// Radix sorts an array of integers using the radix sort algorithm.
func Radix(arr []int) []int {
	if len(arr) == 0 {
		return arr
	}
	// Find the maximum number to know the number of digits
	maxNum := getMax(arr)
	maxDigits := len(strconv.Itoa(maxNum))

	// Perform counting sort for each digit
	for digitPlace := 1; digitPlace <= maxDigits; digitPlace++ {
		arr = countingSortByDigit(arr, digitPlace)
	}
	return arr
}

// getMax returns the maximum element in the array.
func getMax(arr []int) int {
	max := arr[0]
	for _, val := range arr {
		if val > max {
			max = val
		}
	}
	return max
}

// countingSortByDigit performs counting sort based on the specific digit.
func countingSortByDigit(arr []int, digitPlace int) []int {
	n := len(arr)
	output := make([]int, n)
	count := make([]int, 10) // Radix base 10

	// Store count of occurrences in count[]
	for _, num := range arr {
		digit := getDigit(num, digitPlace)
		count[digit]++
	}

	// Change count[i] so that count[i] now contains actual
	// position of this digit in output[]
	for i := 1; i < 10; i++ {
		count[i] += count[i-1]
	}

	// Build the output array
	for i := n - 1; i >= 0; i-- {
		digit := getDigit(arr[i], digitPlace)
		output[count[digit]-1] = arr[i]
		count[digit]--
	}

	return output
}

// getDigit extracts the digit at the given place (1 for units, 2 for tens, etc.)
func getDigit(num int, place int) int {
	for i := 1; i < place; i++ {
		num /= 10
	}
	return num % 10
}
