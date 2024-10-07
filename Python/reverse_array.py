n = int(input("Enter the length of array you wanna input "))
a = []
for i in range(n):
    m = int(input(f"enter the element at {i} of the array "))
    a.append(m)
print("The original array: ", a)

print("Reversed array: ",a[::-1])