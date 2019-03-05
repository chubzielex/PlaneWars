import java.awt.Graphics;


public class gameManager{

	private Player player;

	public gameManager(){

	}

	public void init(){

		player = new Player((gameSetUp.gameWidth / 2) + 50, (gameSetUp.gameHeight - 30) + 50);
		player.init();
	}

	public void tick(){
		player.tick();
	}
	public void render(Graphics g){
		player.render(g);
	

	}
}