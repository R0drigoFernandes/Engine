import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Piso extends Rectangle{
	public Piso(int x, int y) {
		super(x, y,32,32);
		
	}
	public void render(Graphics  g) {
		g.drawImage(SpriteSheet.piso,x,y,null);
	}

}
