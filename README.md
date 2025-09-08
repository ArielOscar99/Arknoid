# Arkanoid Game 🎮

A Java implementation of the classic **Arkanoid / Breakout** arcade game.  
Control the paddle, bounce the ball, and break all the blocks to win!  

---

## ✨ Features
- 🏓 Paddle movement with keyboard controls  
- 🔵 Multiple balls with different speeds and directions  
- 🧱 Blocks arranged in unique patterns per level  
- 🎨 Custom background for each level  
- ⏸️ Pause and resume (press **P**)  
- ⏱️ Countdown before each level starts  
- 🏆 Score tracking across levels  
- 🎉 End screen showing **"You Win!"** or **"Game Over"** with your final score  

---

## 🎮 How to Play
- Move the paddle with the **arrow keys**  
- Don’t let the balls fall below the paddle  
- Break all blocks to clear the level  
- Clear all levels to win the game  
- Press **P** to pause, **SPACE** to continue  

---

## 🚀 Run the Game
### Requirements
- Java 10+  
- Apache Ant  

### Build & Run
Clone the repository:
git clone https://github.com/ArielOscar99/Arkanoid.git
cd Arkanoid

### Compile and run with Ant:

ant compile
ant run


Run specific levels by passing arguments:

ant -Dargs="1 3 4" run


If no arguments are given, the game runs all levels by default.

## 🖼️ Screenshots

<img width="802" height="629" alt="image" src="https://github.com/user-attachments/assets/843e16be-a378-4b63-998c-e4007aa41709" />
<img width="802" height="629" alt="image" src="https://github.com/user-attachments/assets/cacacf4e-af48-4f13-86e5-80adfa2487b1" />


## 🛠️ Project Structure

Ass6Game – main entry point

GameFlow – handles level progression and end screen

GameLevel – runs a single level (paddle, balls, blocks, background)

LevelInformation – defines level configuration

AnimationRunner – controls the game loop (~60 FPS)

## 👤 Author

Ariel Oscar
