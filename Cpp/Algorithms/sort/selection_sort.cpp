#include <iostream>
#include <algorithm>

using namespace std;

// Selection Sort: 
/*
Time Complexity = O(n^2);
Stablity = False;
Adaptive = False;
Sorting in min. no. of sorts.
*/

void show(vector<int> arr){
    for (int i=0;i<arr.size();i++){
        cout << arr[i] << endl;
    }
}

void selectionSort(vector<int>& arr){
    vector<int>::iterator a = arr.begin();

    while (a != arr.end()-1){
        vector<int>::iterator b = a + 1;
        vector<int>::iterator smallest = a;
        while (b != arr.end()){
            if (*b < *smallest){
                smallest = b;
            }
            b+=1;
        }
        int temp = *a;
        *a = *smallest;
        *smallest = temp;
        a += 1;
    }
}

int main(){
    int size;
    cin >> size;

    vector <int> arr(size);
    for (int i=0;i<size;i++){
        cin >> arr[i];
    }

    selectionSort(arr);
    cout << "SORTED ARRAY (BY SELECTION SORT): " << endl;
    show(arr);

    return 0;
}