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
git clone [https://github.com/ArielOscar99/Arkanoid.git](https://github.com/ArielOscar99/Arknoid)
cd Arkanoid

### Compile and run with Ant:

ant compile
ant run

Run specific levels by passing arguments:

ant -Dargs="1 3 4" run

If no arguments are given, the game runs all levels by default.

---

## 🖼️ Screenshots

<img width="802" height="629" alt="image" src="https://github.com/user-attachments/assets/843e16be-a378-4b63-998c-e4007aa41709" />
<img width="802" height="629" alt="image" src="https://github.com/user-attachments/assets/cacacf4e-af48-4f13-86e5-80adfa2487b1" />

---

## 📂 Project Files

### Interfaces
- **Animation** – represents an object that can be animated (drawn frame by frame).
- **Collidable** – represents objects the ball can collide with (blocks, paddle).
- **LevelInformation** – defines all the parameters for a level (balls, paddle, blocks, background, name).
- **Sprite** – represents drawable objects that appear in the game.
- **HitListener** – listener interface for reacting to hit events.
- **HitNotifier** – interface for objects that notify listeners about hits.

### Classes
- **AnimationRunner** – runs animations at a consistent frame rate (~60 FPS).
- **Ass6Game** – main entry point for the game.
- **Background** – draws a level’s background.
- **Ball** – represents the ball, moves and collides with objects.
- **BallRemover** – removes balls when they leave the screen.
- **Block** – represents a breakable block.
- **BlockRemover** – removes blocks when hit and updates the game state.
- **CollisionInfo** – holds details about a collision (point + collidable object).
- **CountDownAnimation** – displays a 3–2–1 countdown at the start of each level.
- **Counter** – keeps track of counts (e.g., score, remaining balls, blocks).
- **GameEnvironment** – holds all collidable objects for collision detection.
- **GameFlow** – manages level sequence, score tracking, and end screen.
- **GameLevel** – runs and manages a single level (paddle, balls, blocks, background).
- **GameOverAnimation** – shows "Game Over" or "You Win" screen with final score.
- **KeyPressStoppableAnimation** – decorator that stops an animation when a key is pressed.
- **Level1 / Level2 / Level3 / Level4** – predefined levels with unique layouts and backgrounds.
- **Line** – geometric line used for collision calculations.
- **Paddle** – the player-controlled paddle.
- **PauseScreen** – animation that shows a paused message until SPACE is pressed.
- **Point** – geometric point class.
- **Rectangle** – represents a rectangle, used for collision and block shapes.
- **ScoreIndicator** – displays the current score on screen.
- **ScoreTrackingListener** – updates the score when blocks are hit.
- **SpriteCollection** – holds and updates all sprites in the game.
- **Velocity** – represents a ball’s speed and direction.

---

## ⚙️ Dependencies

This project uses **`biuoop-1.4.jar`** for the graphical user interface (GUI) and input handling.  
You need to download it and add it to your project’s classpath in order to compile and run the game.

- [Download biuoop-1.4.jar](https://www.cs.biu.ac.il/~intro2cs/biuoop/biuoop-1.4.jar)  
- Place it in your project folder.  
- Update your `build.xml` (Ant) or IDE project settings to include it in the classpath.  

Example:
<path id="classpath">
    <pathelement location="biuoop-1.4.jar"/>
</path>

---

## 👤 Author

Ariel Oscar
