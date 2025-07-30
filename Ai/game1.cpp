#include <SFML/Graphics.hpp>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <algorithm>
#include <limits>
#include <iostream>

const int GRID_SIZE = 4;
const int CELL_SIZE = 150;
const int WINDOW_SIZE = GRID_SIZE * CELL_SIZE;

struct Planet {
    int value;
    int owner; // -1: None, 0: Human, 1: AI
};

class GameState {
public:
    std::vector<std::vector<Planet>> board;
    int currentPlayer;

    GameState() : board(GRID_SIZE, std::vector<Planet>(GRID_SIZE)), currentPlayer(0) {
        for (int i = 0; i < GRID_SIZE; ++i) {
            for (int j = 0; j < GRID_SIZE; ++j) {
                board[i][j] = {rand() % 10 + 1, -1};
            }
        }
    }

    bool makeMove(int x, int y) {
        if (x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE && board[y][x].owner == -1) {
            board[y][x].owner = currentPlayer;
            currentPlayer = 1 - currentPlayer;
            return true;
        }
        return false;
    }

    std::vector<std::pair<int, int>> getPossibleMoves() const {
        std::vector<std::pair<int, int>> moves;
        for (int y = 0; y < GRID_SIZE; ++y) {
            for (int x = 0; x < GRID_SIZE; ++x) {
                if (board[y][x].owner == -1) {
                    moves.emplace_back(x, y);
                }
            }
        }
        return moves;
    }

    bool isTerminal() const {
        return getPossibleMoves().empty();
    }

    int evaluate() const {
        int score = 0;
        for (const auto& row : board) {
            for (const auto& planet : row) {
                if (planet.owner == 0) score += planet.value;
                else if (planet.owner == 1) score -= planet.value;
            }
        }
        return score;
    }
};

std::pair<int, std::pair<int, int>> minimax(GameState& state, int depth, int alpha, int beta, bool maximizingPlayer) {
    if (depth == 0 || state.isTerminal()) {
        return {state.evaluate(), {-1, -1}};
    }

    std::pair<int, int> bestMove;
    if (maximizingPlayer) {
        int maxEval = std::numeric_limits<int>::min();
        for (const auto& move : state.getPossibleMoves()) {
            GameState newState = state;
            newState.makeMove(move.first, move.second);
            int eval = minimax(newState, depth - 1, alpha, beta, false).first;
            if (eval > maxEval) {
                maxEval = eval;
                bestMove = move;
            }
            alpha = std::max(alpha, eval);
            if (beta <= alpha) break;
        }
        return {maxEval, bestMove};
    } else {
        int minEval = std::numeric_limits<int>::max();
        for (const auto& move : state.getPossibleMoves()) {
            GameState newState = state;
            newState.makeMove(move.first, move.second);
            int eval = minimax(newState, depth - 1, alpha, beta, true).first;
            if (eval < minEval) {
                minEval = eval;
                bestMove = move;
            }
            beta = std::min(beta, eval);
            if (beta <= alpha) break;
        }
        return {minEval, bestMove};
    }
}


int main() {
    srand(static_cast<unsigned int>(time(nullptr)));

    sf::RenderWindow window(sf::VideoMode(WINDOW_SIZE, WINDOW_SIZE), "Cosmic Conquest");
    sf::Font font;
    if (!font.loadFromFile("arial.ttf")) {  // Or any other font file you have
        std::cerr << "Error loading font\n";
        return 1;
    }

    GameState gameState;

    while (window.isOpen()) {
        sf::Event event;
        while (window.pollEvent(event)) {
            if (event.type == sf::Event::Closed) {
                window.close();
            }
            if (event.type == sf::Event::MouseButtonPressed && gameState.currentPlayer == 0) {
                sf::Vector2i mousePos = sf::Mouse::getPosition(window);
                int x = mousePos.x / CELL_SIZE;
                int y = mousePos.y / CELL_SIZE;
                if (gameState.makeMove(x, y)) {
                    if (gameState.isTerminal()) {
                        // ... (Game over logic)
                    }
                }
            }
        }        if (gameState.currentPlayer == 1 && !gameState.isTerminal()) {
            // ... (AI move logic)
        }

        window.clear(sf::Color::Black);

        for (int y = 0; y < GRID_SIZE; ++y) {
            for (int x = 0; x < GRID_SIZE; ++x) {
                sf::RectangleShape cell(sf::Vector2f(CELL_SIZE, CELL_SIZE));
                cell.setPosition(sf::Vector2f(x * CELL_SIZE, y * CELL_SIZE)); // Use sf::Vector2f
                // ... (rest of the drawing code)

                sf::Text text;
                text.setFont(font);
                text.setString(std::to_string(gameState.board[y][x].value));  // Use setString
                text.setCharacterSize(30);                text.setFillColor(sf::Color::Black);
                text.setPosition(sf::Vector2f(x * CELL_SIZE + CELL_SIZE / 2 - 15, y * CELL_SIZE + CELL_SIZE / 2 - 15)); // sf::Vector2f
                window.draw(text);

                // ... (rest of the drawing code)
            }
        }

        window.display();
    }

    return 0;
}
