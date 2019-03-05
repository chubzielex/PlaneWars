import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.ArrayList;


public class gameManager{

	private Player player;
	public static ArrayList<Bullet> bullet;

	public gameManager(){

	}

	public void init(){

		player = new Player((gameSetUp.gameWidth / 2) + 50, (gameSetUp.gameHeight - 30) + 50);
		player.init();
		bullet = new ArrayList<Bullet>();
	}

	public void tick(){
		player.tick();

		for (int i = 0; i<bullet.size(); i++){
			bullet.get(i).tick();
		}
		
	}
	public void render(Graphics g){
		player.render(g);

		for (int i = 0; i<bullet.size(); i++){
			bullet.get(i).render(g);
		}	
	}
}