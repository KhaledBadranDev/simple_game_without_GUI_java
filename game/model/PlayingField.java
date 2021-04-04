
/**
 * @author Khaled Badran
 */

package game.model;

import java.util.Random;

public class PlayingField {
    private PlayingFieldTile[][] field = new PlayingFieldTile[10][10];
    private final int SIZE = 10;
    
    public PlayingField() {
        for(int i = 0; i < SIZE; i++)//rows
            for(int j = 0; j < SIZE; j++) //tiles/squares
                field[i][j] = PlayingFieldTile.GROUND;
        
        field[0][0] = PlayingFieldTile.PLAYER;
        field[9][9] = PlayingFieldTile.DESTINATION;
        
        int randRow, randCol;
    
        for(int money = 10; money > 0;){
            randRow = new Random().nextInt(10);
            randCol = new Random().nextInt(10);
            if(field[randRow][randCol] == PlayingFieldTile.GROUND){
                field[randRow][randCol] = PlayingFieldTile.MONEY;
                money--;
            }    
        }
        
        for(int mine = 20; mine > 0;){
            randRow = new Random().nextInt(10);
            randCol = new Random().nextInt(10);
            if(field[randRow][randCol] == PlayingFieldTile.GROUND){
                field[randRow][randCol] = PlayingFieldTile.MINE;
                mine--;
            }    
        }
        
    }
    
    public PlayingField(PlayingFieldTile[][] field) {
        setField(field);
    }
    
    public PlayingFieldTile[][] getField() {
        return field;
    }
    
    public void setField(PlayingFieldTile[][] field) {
        //make sure that the Playing Field Size is correct.
        //The correct Playing Field Size is 10 X 10
        if (field.length != SIZE){//number of (rows/ 1 dimensional arrays)
            System.err.println("Playing Field Size is incorrect.");
            System.exit(1);
        }
        // number of cols/Tiles in every single (row/1 dimensional array)
        for(PlayingFieldTile[] i: field)
            if (i.length != SIZE){ 
                System.err.println("Playing Field Size is incorrect.");
                System.exit(1);
            }
        //if the Playing Field Size is correct, initialize the field member.      
        for(int i = 0; i < SIZE; i++)
            for(int j = 0; j < SIZE; j++)
                this.field[i][j] = field[i][j];
    }
    
    public PlayingFieldTile getTile(int x/*row*/, int y/*col*/) {
        return field[x][y];
    } 
    
    public void setTile(int x/*row*/, int y/*col*/,PlayingFieldTile t) {
        field[x][y] = t;
    }
    
    public int getSize() {
        return this.SIZE;
    }
    
    
    @Override
    public String toString() {
        String playingFieldStructure = " _______________________________________\n";
        for(int i = 0; i < SIZE; i++){//rows
            for(int j = 0; j < SIZE; j++){ //tiles/squares
                    playingFieldStructure += "|" + field[i][j];
            }
            playingFieldStructure += "|\n";    
            for(int j = 0; j < SIZE; j++)
                playingFieldStructure += "|___";
                
            playingFieldStructure += "|\n";
        }
        return playingFieldStructure;
    }
}
