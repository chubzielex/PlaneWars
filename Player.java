import java.awt.Graphics;
import java.awt.Color;

public class Player{

	private int x;
	private int y;

	public Player(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void init(){

	}

	public void tick(){

	}

	public void render(Graphics g){

		g.setColor(Color.red);
		g.fillRect(x, y, 30, 30);
	}
}