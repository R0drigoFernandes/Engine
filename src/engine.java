import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;


public class engine extends Canvas implements Runnable, KeyListener {
    public static int WIDTH = 640, HEIGHT = 480;
    public static int scale = 3;
    public Player player;
    
    public World world;
    public engine() {

        this.addKeyListener(this);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        new SpriteSheet();
        player = new Player(32, 32);
        world = new World();
    }

    public void tick(){
        player.tick();

    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
       
        g.setColor(Color.GREEN);
    	g.fillRect(0, 0, WIDTH * scale , HEIGHT * scale);
        world.render(g);
        player.render(g);

        bs.show();




    }
    public static void main(String[] args) throws Exception {
    	  
    
    	        
    	       
    	    
        engine Engine = new engine();
        JFrame frame = new JFrame();
        frame.add(Engine);
        frame.setTitle("Mini Zelda");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        new Thread(Engine).start();
        




    }
    @Override
    public void run() {

        while (true) { 
           tick();
           render();
           try {
               Thread.sleep(1000/60);
           } catch (Exception e) {
            e.printStackTrace();

           }
           
        }
        

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // Handle key pressed event
        if (keyCode == KeyEvent.VK_UP) {
            // Up key is pressed
            player.up=true;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            // Down key is pressed
           player.down  = true;
        } else if (keyCode == KeyEvent.VK_LEFT) {
            // Left key is pressed
            player.left = true;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            // Right key is pressed
            player.right = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // Handle key released event
        if (keyCode == KeyEvent.VK_UP) {
            // Up key is released
            player.up = false;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            // Down key is released
            player.down = false;
        } else if (keyCode == KeyEvent.VK_LEFT) {
            // Left key is released
            player.left = false;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            // Right key is released
            player.right = false;
        }
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
   
}
