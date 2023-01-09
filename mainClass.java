import processing.core.PApplet;

public class mainClass extends PApplet{
	public static final int scrw = 800;
	public static final int scrh = 800;
	public int num = 0;
	public int num1 = 0;
	private static final int purple = 0xFFA800FF;
	private static final int blue = 0xFF0079FF;
	private static final int green = 0xFF00F11D;
	private static final int yellow = 0xFFFFEF00;
	private static final int orange = 0xFFFF7F00;
	private static final int red = 0xFFFF0900;
	private int color = red;
	private int color1 = yellow;
	private int color2 = orange;
	private int color3 = green;
	private int color4 = blue;
	private int color5 = purple;
	String s = "Dark Mode";
	int bc1 = 0;
	int tc = 255;
	ball b;
	paddle p;
	paddle p2;
	spedPlus sp;
	spedPlus sp1;
	sugarMode sM;
	public boolean titlescreen = false;
	public boolean starting = true;
	public boolean rightwin = false;
	public boolean leftwin = false;
	private int framecount;
	private int framelimit = 10;
	
	public void setup() { 
		float angle = random(180, 200);
		float wallrandom = random(360,365);
		float x= random(150, scrw-150);
		float y = random(30, scrh-20);
		float x1 = random(150, scrw- 150);
		float y1 = random(30, scrh-20);
	
		
		p = new paddle(width/8,height/2, 'w','s');
		b = new ball(20, angle, wallrandom,millis(), 10000, 0);
		// Has Scoreboard, Ball Accelerates, Random Bounce Walls, Random Bounce on Paddle, Paddle Accelerate
		//Also, dark and light mode, resets at 21
		
		p2 = new paddle(width-100, height/2, 'i', 'k');
		colorupdate();
		sM = new sugarMode(5, radians(50), color, millis(), 10000, 0);
		sp = new spedPlus(x, y, 30, 60, 2000, 0, millis(), purple);
		sp1 = new spedPlus(x1, y1, 30, 60, 2000, 0, millis(), blue);
		framelimit = 0;
		
		
	}
	public void draw() {
		background(bc1);
		colorupdate();
		if(starting == true) {
			textSize(50);
			fill(color);
			text("Wong Pong", width/2, height/2);
			textSize(30);
			fill(tc);
			text("Space to Continue", width/2 + 50, height/2 + 50);
		}
		if(titlescreen == true) {
			textAlign(CENTER);
			textSize(50);
			fill(tc);
			text("Game Over", width/2, height/2);
			textSize(30);
			textAlign(CENTER);
			fill(tc);
			text("Press Space to Start Over", width/2 - 50, height/2 -50);
		}
		if(rightwin == true) {
			fill(tc);
			textAlign(RIGHT);
			text("You win", width - 100, height/2);
			textAlign(LEFT);
			text("You lost", width/8, height/2);
		}
		if(leftwin == true) {
			fill(tc);
			textAlign(LEFT);
			text("You win", width/8, height/2);
			textAlign(RIGHT);
			text("You lost", width - 100, height/2);
		}
		if(titlescreen == false && starting == false) {
			textSize(30);
			fill(tc);
			text(num, width-100, height/10);
		
			textSize(30);
			fill(tc);
			text(num1, width/8, height/10);
			
			textAlign(LEFT);
			textSize(16);
			fill(tc);
			text(s, 10, 30);
		
			sp.draw(this);
			sp1.draw(this);
			sp.update(this);
			sp1.update(this);
			
			p.draw(this);
			p2.draw(this);
			p.update(this);
			p2.update(this);
		
			b.draw(this);
			b.update(this, this);
			b.collision(p, sM);
			b.collision(p2, sM);
			b.pc(sp, sp1);
			
			sM.draw(this);
			sM.update(this, p, b);
			sM.update(this, p2, b);
			
			
			update();
			
}

	}


	public void update() {
		if (num == 11 || num1 == 11) {
			num = 0;
			num1 = 0;
			titlescreen = true;
		}
		if(num1 == 11) {
			leftwin = true;
		}
		if(num == 11) {
			rightwin = true;
		}
	}
	public void colorupdate() {
		framecount++;
		if(framecount >= framelimit) {
			int temp;
			temp = color;
			color = color1;
			color1 = color2;
			color2 = color3;
			color3 = color4;
			color4 = color5;
			color5 = temp;
		}
	}
	

	
	public void keyPressed() {
		p.keyPressed(key);
		p2.keyPressed(key);
		if (key == 'r') {
			b.reset();
			sM.reset1();
		}
		if(key == 'd') {
			bc1 = 0;
			tc = 255;
			s = "Dark Mode";
		
		}
		if(key == 'l') {
			bc1 = 255;
			tc = 0;
			s = "Light Mode";
		}
		if(key == ' ') {
			titlescreen = false;
			starting = false;
			leftwin = false;
			rightwin = false;
		}
	}
	public void keyReleased() {
		p.keyReleased(key);
		p2.keyReleased(key);
	}
	public void settings() {
		size(scrw,scrh);
	}
	public static void main(String[] args) {
		PApplet.main("mainClass");

	}

}
