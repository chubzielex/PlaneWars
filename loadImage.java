import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class loadImage{

	public static BufferedImage image;
	public static BufferedImage enemy;
	public static BufferedImage bullet;
	public static BufferedImage ship;

	


	public static void init(){
		image = imageLoader("space.png");
		bullet = imageLoader("MegaLaser.png");
		ship = imageLoader("ship.png");
		enemy = imageLoader("enemy.png");
		
	
	} 


	public static BufferedImage imageLoader(String path){
		try{
			return ImageIO.read(loadImage.class.getResource(path));
		} catch (IOException e){
			e.printStackTrace();
			System.exit(1); 
		} return null;
	}

}