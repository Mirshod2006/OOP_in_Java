import pygame
import sys

# Pygame ni boshlash
pygame.init()

# Oyna o'lchamlari
width, height = 800, 600
screen = pygame.display.set_mode((width, height))
pygame.display.set_caption("Harakatlanayotgan mashina")

# Ranglar
WHITE = (255, 255, 255)
BLUE = (0, 0, 255)

# Mashina xususiyatlari
car_width, car_height = 50, 30
car_x, car_y = width // 2, height // 2
car_speed = 5

# O'yin sikli
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

    # Klaviatura tugmalari bilan harakat
    keys = pygame.key.get_pressed()
    if keys[pygame.K_LEFT]:
        car_x -= car_speed
    if keys[pygame.K_RIGHT]:
        car_x += car_speed
    if keys[pygame.K_UP]:
        car_y -= car_speed
    if keys[pygame.K_DOWN]:
        car_y += car_speed

    # Ekranni tozalash
    screen.fill(WHITE)

    # Mashinani chizish
    pygame.draw.rect(screen, BLUE, (car_x, car_y, car_width, car_height))

    # Oynani yangilash
    pygame.display.flip()

    # FPS ni belgilash
    pygame.time.Clock().tick(60)
