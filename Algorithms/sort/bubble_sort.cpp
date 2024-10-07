#include <iostream>
#include <vector>
#include <set>

using namespace std;

// Bubble sort >>
/*

Time Complexity = O(n^2);
Adaptive = True;
Recursive = False(here); // can be recursive in some approach.

*/

void show(vector<int> arr){
    for (int i=0;i<arr.size();i++){
        cout << arr[i] << endl;
    }
}

void bubbleSort(vector<int>& arr){
    
    for (vector<int>::iterator iter = arr.end();iter!=arr.begin();iter--){
        int isSorted = 1;
        // cout << "iteration!" << endl;
        vector<int>:: iterator a = arr.begin();
        vector<int>:: iterator b = arr.begin()+1;
        while (b != iter){
            if (*b < *a){
                // cout << "swap!" << endl;
                int temp = *a;
                *a = *b;
                *b = temp;
                isSorted = 0;
            }
            b+=1;
            a+=1;
        }
        if (isSorted){
            break;
        }
    }
}

int main(){
    int size;
    cin >> size;
    vector<int> arr(size);
    for (int i=0;i<size;i++){
        cin >> arr[i];
    }

    cout << "SORTED ARRAY: " << endl;
    bubbleSort(arr);
    show(arr);



    return 0;
}