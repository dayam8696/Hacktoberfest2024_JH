#include <iostream>
#include <conio.h>    // For _kbhit() and _getch()
#include <windows.h>  // For Sleep()
using namespace std;

const int width = 20;
const int height = 10;
int basketX = width / 2;  // Basket starts in the middle
int fallingObjectX;
int fallingObjectY;
int score = 0;
bool gameOver = false;

void Setup() {
    fallingObjectX = rand() % width; // Random falling object position
    fallingObjectY = 0;              // Object starts falling from the top
    score = 0;
    gameOver = false;
}

void Draw() {
    system("cls");  // Clear the screen

    // Top border
    for (int i = 0; i < width + 2; i++)
        cout << "#";
    cout << endl;

    // Draw the game area
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            if (j == 0)
                cout << "#";  // Left border

            if (i == fallingObjectY && j == fallingObjectX)
                cout << "*";  // Falling object
            else if (i == height - 1 && j == basketX)
                cout << "U";  // Basket (at the bottom)
            else
                cout << " ";

            if (j == width - 1)
                cout << "#";  // Right border
        }
        cout << endl;
    }

    // Bottom border
    for (int i = 0; i < width + 2; i++)
        cout << "#";
    cout << endl;

    // Display score
    cout << "Score: " << score << endl;
}

void Input() {
    if (_kbhit()) {
        switch (_getch()) {
        case 'a':
            if (basketX > 0)
                basketX--;  // Move basket left
            break;
        case 'd':
            if (basketX < width - 1)
                basketX++;  // Move basket right
            break;
        case 'x':
            gameOver = true;  // Exit the game
            break;
        }
    }
}

void Logic() {
    fallingObjectY++;  // Object moves down each frame

    // Check if the object reaches the bottom
    if (fallingObjectY == height - 1) {
        if (fallingObjectX == basketX) {
            score += 10;  // Catching the object increases the score
        } else {
            gameOver = true;  // Missing the object ends the game
        }
        // Respawn the object at a random position at the top
        fallingObjectX = rand() % width;
        fallingObjectY = 0;
    }
}

int main() {
    Setup();
    while (!gameOver) {
        Draw();
        Input();
        Logic();
        Sleep(100);  // Control the speed of the falling object
    }

    cout << "Game Over!" << endl;
    cout << "Final Score: " << score << endl;
    return 0;
}


// Falling Object: An object (represented by *) falls from the top of the screen towards the basket (U) at the bottom.
// Player Input: The player controls the basket using the a key to move left and the d key to move right.
// Collision Detection: If the object reaches the bottom and the basket is positioned to catch it, the score increases. If the basket misses, the game is over.
// Game Loop: The game keeps running until the player either catches the object or misses it, at which point it shows the final score.#include <iostream>
#include <conio.h>    // For _kbhit() and _getch()
#include <windows.h>  // For Sleep()
using namespace std;

const int width = 20;
const int height = 10;
int basketX = width / 2;  // Basket starts in the middle
int fallingObjectX;
int fallingObjectY;
int score = 0;
bool gameOver = false;

void Setup() {
    fallingObjectX = rand() % width; // Random falling object position
    fallingObjectY = 0;              // Object starts falling from the top
    score = 0;
    gameOver = false;
}

void Draw() {
    system("cls");  // Clear the screen

    // Top border
    for (int i = 0; i < width + 2; i++)
        cout << "#";
    cout << endl;

    // Draw the game area
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            if (j == 0)
                cout << "#";  // Left border

            if (i == fallingObjectY && j == fallingObjectX)
                cout << "*";  // Falling object
            else if (i == height - 1 && j == basketX)
                cout << "U";  // Basket (at the bottom)
            else
                cout << " ";

            if (j == width - 1)
                cout << "#";  // Right border
        }
        cout << endl;
    }

    // Bottom border
    for (int i = 0; i < width + 2; i++)
        cout << "#";
    cout << endl;

    // Display score
    cout << "Score: " << score << endl;
}

void Input() {
    if (_kbhit()) {
        switch (_getch()) {
        case 'a':
            if (basketX > 0)
                basketX--;  // Move basket left
            break;
        case 'd':
            if (basketX < width - 1)
                basketX++;  // Move basket right
            break;
        case 'x':
            gameOver = true;  // Exit the game
            break;
        }
    }
}

void Logic() {
    fallingObjectY++;  // Object moves down each frame

    // Check if the object reaches the bottom
    if (fallingObjectY == height - 1) {
        if (fallingObjectX == basketX) {
            score += 10;  // Catching the object increases the score
        } else {
            gameOver = true;  // Missing the object ends the game
        }
        // Respawn the object at a random position at the top
        fallingObjectX = rand() % width;
        fallingObjectY = 0;
    }
}

int main() {
    Setup();
    while (!gameOver) {
        Draw();
        Input();
        Logic();
        Sleep(100);  // Control the speed of the falling object
    }

    cout << "Game Over!" << endl;
    cout << "Final Score: " << score << endl;
    return 0;
}


// Falling Object: An object (represented by *) falls from the top of the screen towards the basket (U) at the bottom.
// Player Input: The player controls the basket using the a key to move left and the d key to move right.
// Collision Detection: If the object reaches the bottom and the basket is positioned to catch it, the score increases. If the basket misses, the game is over.
// Game Loop: The game keeps running until the player either catches the object or misses it, at which point it shows the final score.