#include <iostream>
using namespace std;

// Define the structure for the linked list node
struct Node {
    int data;
    Node* next;
};

// Function to count the number of nodes in the linked list
int getCount(Node* head) {
    Node* p = head;
    int cnt = 0;
    
    // Traverse the list and count the nodes
    while (p != NULL) {
        cnt++;
        p = p->next;
    }
    
    return cnt;
}

// Function to insert a new node at the beginning of the list
void push(Node** head_ref, int new_data) {
    Node* new_node = new Node();
    new_node->data = new_data;
    new_node->next = (*head_ref);
    (*head_ref) = new_node;
}

// Main function to test the code
int main() {
    Node* head = NULL;
    
    // Insert some nodes
    push(&head, 1);
    push(&head, 2);
    push(&head, 3);
    push(&head, 4);
    
    // Get the count of nodes
    cout << "Count of nodes is " << getCount(head) << endl;
    
    return 0;
}
