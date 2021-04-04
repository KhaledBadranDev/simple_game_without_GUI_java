
/**
 * @author Khaled Badran
 */


package game.simulation;

import java.util.Scanner;
import game.model.*;
import game.util.Util; 

public class Simulation extends PlayingField{
    
    private Player player = new Player();
    
    
    private String getPlayerMove() {
        String move = "";
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Please enter one of the following directions (w, a, s, d)");
            System.out.println("w = up, s = down, d = right, a = left");
            move = input.next().toLowerCase();
            if(move.equals("w")||move.equals("s")||move.equals("d")||move.equals("a"))
                break;
        }
        return move;
    }
    
    private boolean isInsideField(String move) {
        int tmpXPosition = 0;
        int tmpYPosition = 0;
        if(move.equals("w"))
            tmpXPosition = player.getPlayerXPosition()-1;
        else if(move.equals("s")) 
            tmpXPosition = player.getPlayerXPosition()+1;
        else if(move.equals("a"))
            tmpYPosition = player.getPlayerYPosition()-1;
        else if(move.equals("d")) 
            tmpYPosition = player.getPlayerYPosition()+1;

        if (tmpXPosition < getSize() && tmpYPosition < getSize() && tmpXPosition >= 0 && tmpYPosition >= 0)
            return true;
        return false;
    }
    
    private void updateGame(int previousX, int previousY, int newX, int newY) {
        setTile(previousX, previousY, PlayingFieldTile.GROUND);
        if (getTile(newX, newY) == PlayingFieldTile.GROUND)
            setTile(newX, newY, PlayingFieldTile.PLAYER);
        else if(getTile(newX, newY) == PlayingFieldTile.MINE){
            setTile(newX, newY, PlayingFieldTile.DEATH);
            player.setDead(true);
            player.setGameOver(true);
        }else if(getTile(newX, newY) == PlayingFieldTile.MONEY){
            setTile(newX, newY, PlayingFieldTile.PLAYER);
            player.increaseScore();
        }else if(getTile(newX, newY) == PlayingFieldTile.DESTINATION){
            setTile(newX, newY, PlayingFieldTile.PLAYER);
            player.setGameOver(true);
        }
    }
    
    public void movePlayer() {
        String movement = getPlayerMove();
        int previousX = player.getPlayerXPosition();
        int previousY = player.getPlayerYPosition();
        
        if (isInsideField(movement)){
            if(movement.equals("w"))
                player.setPlayerXPosition(player.getPlayerXPosition()-1);
            else if(movement.equals("s")) 
                player.setPlayerXPosition(player.getPlayerXPosition()+1);
            else if(movement.equals("a"))
                player.setPlayerYPosition(player.getPlayerYPosition()-1);
            else if(movement.equals("d")) 
                player.setPlayerYPosition(player.getPlayerYPosition()+1);
                
            updateGame(previousX, previousY, player.getPlayerXPosition(), player.getPlayerYPosition());    
        } else {
            System.out.println("sorry, you can't get out of the playing field!");
            movePlayer();
        }
    } 
    
    
    public void run() {
        if (player.isGameOver()){
            if (player.isDead()) System.out.println("sorry, you lost -_-");
            else {
                System.out.println("   VICTORY");
                System.out.println("  YOU WON :)");
                System.out.println("  your score is: " + String.valueOf(player.getScore()));
            }
            return;
        }
        
        Util.clearScreen();
        System.out.println(this);
        movePlayer();
        Util.sleep(500);
        Util.clearScreen();
        System.out.println(this);
        run();
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
}
