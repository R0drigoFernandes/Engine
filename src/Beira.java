import java.awt.Graphics;
import java.awt.Rectangle;


public class Beira extends Rectangle{
	public Beira(int x, int y) {
		super(x, y,32,32);
		
	}
	public void render(Graphics  g) {
		g.drawImage(SpriteSheet.beira,x,y,null);
	}

}