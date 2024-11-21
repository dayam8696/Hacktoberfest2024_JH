# Python implementation for subset sum
# problem using recursion
def isSubsetSumRec(arr, n, sum):
  
    # Base Cases
    if sum == 0:
        return True 
    if n == 0:
        return False

    # If the last element is greater
    # than the sum, ignore it
    if arr[n - 1] > sum:
        return isSubsetSumRec(arr, n - 1, sum)

    # Check if sum can be obtained by including
    # or excluding the last element
    return (isSubsetSumRec(arr, n - 1, sum) or 
            isSubsetSumRec(arr, n - 1, sum - arr[n - 1]))

def isSubsetSum(arr, sum):
    return isSubsetSumRec(arr, len(arr), sum)

if __name__ == "__main__":
  
    arr = [3, 34, 4, 12, 5, 2]
    sum = 9

    if isSubsetSum(arr, sum):
        print("True")
    else:
        print("False")
