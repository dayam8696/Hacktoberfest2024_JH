#include <iostream>
using namespace std;

class ArrayManipulator {
private:
    int *arr;  
    int size;
    const int MAX_SIZE = 1000;  
public:
    ArrayManipulator(int s) {
        if (s > MAX_SIZE) {
            cout << "Size exceeds maximum allowed size!" << endl;
            exit(1);
        }
        size = s;
        arr = new int[size];
    }
    ~ArrayManipulator() {
        delete[] arr;
    }
    void inputArray() {
        cout << "Enter " << size << " elements of the array: ";
        for (int i = 0; i < size; i++) {
            cin >> arr[i];
        }
    }
    void reverseArray() {
        int start = 0;
        int end = size - 1;
        
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    void printArray() const {
        for (int i = 0; i < size; i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
};

int main() {
    int n;
    cout << "Enter the size of the array: ";
    cin >> n;
    ArrayManipulator arrManipulator(n);
    arrManipulator.inputArray();
    arrManipulator.reverseArray();
    cout << "Reversed array: ";
    arrManipulator.printArray();
    return 0;
}
