import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
    public int  vida = 100;
    public String nome = "Cyber";
    public boolean right, left, up, down;
    public int spd = 4;
    public Player(int x, int y){
        super(x , y, 32, 32);
    }
    public void tick(){
        if(right && World.isFree(x + spd, y)){
            x += spd;
        }else if(left && World.isFree(x - spd, y)){ 
            x -= spd;
        }
        if(up && World.isFree(x, y - spd)){
            y -= spd;
        }else if(down && World.isFree(x, y + spd)){
            y += spd;
        }
    }

    public void render(Graphics g){
    	g.drawImage(SpriteSheet.player[0], x, y, 32,32, null);
    	 if(up) {
    		g.drawImage(SpriteSheet.player[1], x, y, 32,32, null);
    	}else if(right) {
    		
    		g.drawImage(SpriteSheet.player[2], x, y, 32,32, null);
    	}else if(left) {
    		g.drawImage(SpriteSheet.player[3], x, y, 32,32, null);
    	}

        

    }
    
    public void perderVida(){
        vida--;
    }
    public void ganharVida(){
        if(vida < 100){
        vida++;
        }
    }
    
}
