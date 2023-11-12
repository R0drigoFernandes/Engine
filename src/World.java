import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
public class World {
    public static  List<Blocks> blocos = new ArrayList<Blocks>();
    public  static List<Piso>  piso  = new ArrayList<Piso>();
    public static List<Beira>  beira = new ArrayList<Beira>();
    
    public World(){
    	
        for (int xx = 0; xx < 20; xx++) {
        	if(xx > 0 &&  xx < 19) {
            blocos.add(new Blocks(xx*32, 0));
        	}else {
        		
        		beira.add(new  Beira(xx * 32, 0));
        	}
        }

        for (int yy = 0; yy < 20; yy++) {
        	if(yy >  0 && yy < 19) {
            blocos.add(new Blocks(0, yy*32));
        	}else {
        		beira.add(new  Beira( 0, yy*32));
        	}
        }
        for(int xx  = 0; xx < 20; xx++){
        	if(xx  > 0 && xx < 19) {
            blocos.add(new Blocks(xx*32, 480-32));
        	}else {
        		beira.add(new Beira (xx * 32, 480-32));
        	}
        }
        for(int yy = 0; yy < 20; yy++){
        	if(yy  > 0 && yy < 19) {
            blocos.add(new Blocks(640-32, yy*32));
        	}else {
        		
        		beira.add(new Beira(640-32,yy*32));
        	}
        }
       

    }
    public static boolean isFree(int x, int y){
        for (int i = 0; i < blocos.size(); i++) {
            Blocks b = blocos.get(i);
            
            if(b.intersects(new Rectangle(x, y, 30, 30))){
                return false;
            }
           
        }
        return true;
    }
    public void  render(Graphics g){
    	
    	 for(int b =  0;b < beira.size();b++) {
    		 beira.get(b).render(g);
    	 }
        for (int i = 0; i < blocos.size(); i++) {
            blocos.get(i).render(g);
        }
       
        

    }
    
}
