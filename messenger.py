from pyautogui import press, typewrite, hotkey
import time

time.sleep(5)

def makeKeyStrokes(word):
    typewrite(word)
    press('enter')


file = open("movie.txt", "r")
count = 0
while (count < 1000):
    count += 1
    line = file.readline().strip()
    lineSplit = line.split();
    for i in range(len(lineSplit)):
        makeKeyStrokes(lineSplit[i])
