import pygame
import cmath
pygame.init()
(width, height) = (3440, 1440)
screen = pygame.display.set_mode((width, height))
screen.fill((255, 255, 255))
pygame.display.flip()
running = True

#Distance between point a and the origin o
def distanceFromOrigin(a, o):
    distX = abs(a.real - o.real)
    distY = abs(a.imag - o.imag)
    dist = cmath.sqrt((distX * distX) + (distY * distY))
    return dist.real

#Determine how stable iterations are from a given point
def getIterationCount(o):
    current = o
    iterationCount = 0
    for i in range(1000):
        current *= current
        current += o
        if (distanceFromOrigin(current, o) >= 2):
            break
        iterationCount += 1
    return iterationCount * 3

#Determine the color of the square based on the stablility
def getColorFromIterations(iterationCount):
    return (
        255 - max(0, min(255, iterationCount - 255 - 255)),
        255 - max(0, min(255, iterationCount - 255)),
        255 - max(0, min(255, iterationCount))
    )

#Colors a given point on the screen
def colorSquare(x, y, color):
    pygame.draw.rect(screen, color, (x, y, 1, 1))

#Draws the mandelbrot set onto a screen of size (width) * (height)
def drawSet(width, height):
    for i in range(width):
        for j in range(height):
            currentPoint = complex((i - width//2) / 700, (j - height//2) / 700)
            iterationCount = getIterationCount(currentPoint)
            color = getColorFromIterations(iterationCount)
            colorSquare(i, j, color)
        print(str((i / width) * 100) + "% Complete")
    pygame.display.update()
    print("DONE")

drawSet(width, height)
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
