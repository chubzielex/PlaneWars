import java.awt.Color;
import java.awt.Graphics;



public class Enemy{

		private int x;
		private int y;



	public Enemy(int x, int y){

		this.x = x;
		this.y = y;
	}

	public void tick(){

		y += 1;
	}

	public void render(Graphics g){

		g.setColor(Color.black);
		g.fillOval(x,y,25,25);
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

}