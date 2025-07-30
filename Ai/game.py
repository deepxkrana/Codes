import pygame
import random
import sys

# Initialize Pygame
pygame.init()

# Constants
WIDTH, HEIGHT = 600, 600
GRID_SIZE = 4
CELL_SIZE = WIDTH // GRID_SIZE
FPS = 30

# Colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
BLUE = (0, 0, 255)
RED = (255, 0, 0)
GREEN = (0, 255, 0)

# Setup the display
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption('Cosmic Conquest')

# Font for displaying text
font = pygame.font.SysFont(None, 40)

# Generate random planet values
planets = [[random.randint(1, 10) for _ in range(GRID_SIZE)] for _ in range(GRID_SIZE)]
owners = [[None for _ in range(GRID_SIZE)] for _ in range(GRID_SIZE)]
current_player = 0  # 0: Human, 1: AI

def draw_grid():
    for y in range(GRID_SIZE):
        for x in range(GRID_SIZE):
            rect = pygame.Rect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE)
            pygame.draw.rect(screen, WHITE, rect, 1)
            if owners[y][x] is not None:
                color = BLUE if owners[y][x] == 0 else RED
                pygame.draw.rect(screen, color, rect)
            text = font.render(str(planets[y][x]), True, GREEN)
            screen.blit(text, (x * CELL_SIZE + CELL_SIZE // 2 - text.get_width() // 2,
                               y * CELL_SIZE + CELL_SIZE // 2 - text.get_height() // 2))

def make_move(x, y):
    global current_player
    if owners[y][x] is None:
        owners[y][x] = current_player
        current_player = 1 - current_player

def ai_move():
    # Very simple AI: just choose a random empty cell
    empty_cells = [(x, y) for y in range(GRID_SIZE) for x in range(GRID_SIZE) if owners[y][x] is None]
    if empty_cells:
        x, y = random.choice(empty_cells)
        owners[y][x] = current_player

def main():
    clock = pygame.time.Clock()
    running = True
    while running:
        screen.fill(BLACK)
        draw_grid()

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
            elif event.type == pygame.MOUSEBUTTONDOWN and current_player == 0:
                mouse_x, mouse_y = event.pos
                grid_x = mouse_x // CELL_SIZE
                grid_y = mouse_y // CELL_SIZE
                make_move(grid_x, grid_y)

        if current_player == 1:
            ai_move()
            current_player = 0

        pygame.display.flip()
        clock.tick(FPS)

    pygame.quit()
    sys.exit()

if __name__ == "__main__":
    main()
