import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class SpriteSheet {
    public static BufferedImage spriteSheet;
    public static BufferedImage[] player;
    public static BufferedImage Wall;
    public static BufferedImage piso;
    public static BufferedImage beira;
    
    
      public  SpriteSheet(){
         try {
             spriteSheet = ImageIO.read(SpriteSheet.class.getResourceAsStream("/sprites.png"));
             
         } catch (Exception e) {
             e.printStackTrace();
         }
         player = new BufferedImage[4];
         player[0] = spriteSheet.getSubimage(0, 0, 32, 32);
         player[1] = spriteSheet.getSubimage(0, 0, 32, 32);
         player[2] = spriteSheet.getSubimage(0, 0, 32, 32);
         player[3] = spriteSheet.getSubimage(0,0  ,32, 32);
         Wall = spriteSheet.getSubimage(33, 0, 32, 32);
         piso = spriteSheet.getSubimage(99, 0, 32, 32);
         beira = spriteSheet.getSubimage(66, 0, 32, 32);
      }
      public static BufferedImage getSprite(int x, int y, int width, int height){
          return spriteSheet.getSubimage(x, y, width, height);
      }
     
      
      
}
