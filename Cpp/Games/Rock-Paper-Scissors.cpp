#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;
string getChoiceName(int choice) {
    switch (choice) {
        case 1: return "Rock";
        case 2: return "Paper";
        case 3: return "Scissors";
        default: return "";
    }
}
void decideWinner(int playerChoice, int computerChoice) {
    cout << "You chose: " << getChoiceName(playerChoice) << endl;
    cout << "Computer chose: " << getChoiceName(computerChoice) << endl;
    if (playerChoice == computerChoice) {
        cout << "It's a tie!" << endl;
    } 
    else if ((playerChoice == 1 && computerChoice == 3) || 
             (playerChoice == 2 && computerChoice == 1) || 
             (playerChoice == 3 && computerChoice == 2)) {
        cout << "You win!" << endl;
    } 
    else {
        cout << "Computer wins!" << endl;
    }
}

int main() {
    int playerChoice;
    srand(time(0));

    cout << "Welcome to Stone-Paper-Scissors!" << endl;
    cout << "Enter your choice: (1) Rock, (2) Paper, (3) Scissors: ";
    cin >> playerChoice;
    if (playerChoice < 1 || playerChoice > 3) {
        cout << "Invalid choice! Please choose 1, 2, or 3." << endl;
        return 1; 
    }

    int computerChoice = rand() % 3 + 1;

    decideWinner(playerChoice, computerChoice);

    return 0;
}
