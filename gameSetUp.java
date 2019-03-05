public class gameSetUp implements Runnable {

	private String title;
	private int width;
	private int height;
	private Thread thread;
	private boolean running;

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

	public void run(){
		init();
	}
}