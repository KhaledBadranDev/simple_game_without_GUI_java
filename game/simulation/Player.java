
/**
 * @author Khaled Badran
 */

package game.simulation;

class Player {

    private int playerXPosition;
    private int playerYPosition;
    private int score;
    private boolean gameOver;
    private boolean dead;
    
    public Player() {
        playerXPosition = 0;
        playerYPosition = 0;
        score = 0;
        gameOver = false;
        dead = false;
    }
    
    public int getPlayerXPosition() {
        return playerXPosition;
    }
    
    public int getPlayerYPosition() {
        return playerYPosition;
    }
    
    public int getScore() {
        return score;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
    
    public boolean isDead() {
        return dead;
    }
    
    public void setPlayerXPosition(int x) {
        playerXPosition = x;
    }
    
    public void setPlayerYPosition(int y) {
        playerYPosition = y;
    }
    
    public void increaseScore() {
        score++;
    }
    
    public void setGameOver(boolean status) {
        gameOver = status;
    }
    
    public void setDead(boolean status) {
        dead = status;
    }
    
}
