import java.awt.image.BufferStrategy;
import java.awt.Graphics;

public class gameSetUp implements Runnable {

	private String title;
	private int width;
	private int height;
	private Thread thread;
	private boolean running;
	private BufferStrategy buffer;
	private Graphics g;
	private int y;

	private Display display;	

	public gameSetUp(String title, int width, int height){

		this.title = title;
		this.width = width;
		this.height = height;

	}

	public void init(){
		display = new Display(title, width, height);
	}

	public synchronized void start(){
		if(running)
			return;

		running = true;

		if (thread == null){
		thread = new Thread(this);
		thread.start();
		}
	}

	public synchronized void stop(){
		if(!(running))
			return;

		running = false;

		try{
			thread.join();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public void tick(){

		y +=1;
	}

	public void render(){
		buffer = display.getCanvas().getBufferStrategy();
			if(buffer == null){
			display.getCanvas().createBufferStrategy(3);
				return;
			}

		g = buffer.getDrawGraphics();
		g.clearRect(0, 0, width, height);

		g.fillRect(33, y, 44, 44);

		buffer.show();
		g.dispose();
	}

	public void run(){
		
		init();

		int fps = 50;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long current = System.nanoTime();

		while (running){
			delta = delta + (System.nanoTime() - current)/timePerTick;
			current = System.nanoTime();
				if(delta>=1){
			tick();
			render();
			delta--;
			}
		}
	}
}
