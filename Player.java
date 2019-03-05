import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener{ 

	private int x;
	private int y;
	private boolean left,right;
	private boolean fire;


	public Player(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void init(){

		Display.frame.addKeyListener(this);

	}

	public void tick(){

		if(left){
				if(x>=50){
					x -=6;
				}
			}

		if(right){
				if(x<=450-30){
					x +=6;
				}
			}

		if(fire){
			gameManager.bullet.add(new Bullet(x, y));
		}


	}


	public void render(Graphics g){

		g.setColor(Color.red);
		g.fillRect(x, y, 30, 30);
	}

	public void keyPressed(KeyEvent e){
		int source = e.getKeyCode();

		if(source == KeyEvent.VK_LEFT){
			left = true;
		}

		if(source == KeyEvent.VK_RIGHT){
			right = true;
		}

		if(source == KeyEvent.VK_B){
			fire = true;
		}

	}

	public void keyReleased(KeyEvent e){
		int source = e.getKeyCode();


		if(source == KeyEvent.VK_LEFT){
			left = false;
		}

		if(source == KeyEvent.VK_RIGHT){
			right = false;
		}

		if(source == KeyEvent.VK_B){
			fire = false;
		}

	}

	public void keyTyped(KeyEvent e){

	}


}

