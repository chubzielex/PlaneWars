import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.ArrayList;
import java.lang.*;


public class gameManager{

	private Player player;
	public static ArrayList<Bullet> bullet;
	private ArrayList<Enemy> enemies;

	private long current;
	private long delay;
	private int health;

	public gameManager(){

	}

	public void init(){

		player = new Player((gameSetUp.gameWidth / 2) + 50, (gameSetUp.gameHeight - 60) + 50);
		player.init();
		bullet = new ArrayList<Bullet>();
		enemies = new ArrayList<Enemy>();
		current = System.nanoTime();
		delay = 800;
		health = player.getHealth();
	}

	public void tick(){
		player.tick();

		for (int i = 0; i<bullet.size(); i++){
			bullet.get(i).tick();
		}

		long breaks = (System.nanoTime()-current)/1000000;

		if(breaks > delay){
			for (int i = 0; i<2; i++){
				Random rand = new Random();
				int randX = rand.nextInt(450);
				int randY = rand.nextInt(450);

				if(health > 0){
				enemies.add(new Enemy(randX, -randY));
				}
			}
			current = System.nanoTime();
		}	

		for (int i = 0; i<enemies.size(); i++){
			enemies.get(i).tick();
		}


		
	}
	public void render(Graphics g){
		player.render(g);

		for (int i = 0; i<bullet.size(); i++){
			bullet.get(i).render(g);
		}

		for(int i = 0; i<enemies.size(); i++){
				if(!(enemies.get(i).getX()<=50 || enemies.get(i).getX()>=450 - 50 || enemies.get(i).getY()>=450 - 50)){

					if(enemies.get(i).getY()>= 50){
						enemies.get(i).render(g);
					}
				}
			}
			//collision bullet to enemy.
		for(int i = 0; i<enemies.size(); i++){
			int ex = enemies.get(i).getX();
			int ey = enemies.get(i).getY();

			int px = player.getX();
			int py = player.getY();

			if(px < ex + 25 && px + 30 > ex && py < ey + 25 && py + 30 > ey){
				enemies.remove(i);
				i--;
				health --;
				System.out.println(health);
				if(health <= 0){
					enemies.removeAll(enemies);
					player.setHealth(0);
				}
			}

			for(int j =0; j<bullet.size(); j++){
				int bx = bullet.get(j).getX();
				int by = bullet.get(j).getY();

				if(ex < bx + 6 && ex + 25 > bx && ey < by + 6 && ey + 25 > by){
						enemies.remove(i);
						i--;
						bullet.remove(j);
						j--;
					}

			}	
		}
	}
}