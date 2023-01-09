import processing.core.PApplet;

public class paddle {
	private static final int purple = 0xFFA800FF;
	private static final int blue = 0xFF0079FF;
	private static final int green = 0xFF00F11D;
	private static final int yellow = 0xFFFFEF00;
	private static final int orange = 0xFFFF7F00;
	private static final int red = 0xFFFF0900;
	private float x, y;
	private char upk, downk;
	private boolean upressed, dpressed;
	private int boxwidth = 10;
	private int boxheight = 90;
	private int framecount;
	private int color, color1, color2, color3, color4, color5;
	private int framelimit = 10;
	private int accel = 0;
	private int daccel = 0;
	private int hold = 1;

	

	public paddle(float x, float y, char upk, char downk) {
		this.x = x;
		this.y = y;

		this.upk = upk;
		this.downk = downk;
		

		upressed = false;
		dpressed = false;
		color = red;
		color1 = yellow;
		color2 = orange;
		color3 = green;
		color4 = blue;
		color5 = purple;
		framecount = 0;
		


	}

	public void draw(PApplet p) {
		p.noStroke();
		p.rectMode(PApplet.CENTER);
		p.fill(color);

		p.rect(x, y, boxwidth, boxheight);
	}

	public void update(PApplet p) {
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
		if (y + boxheight /2 < p.height) {
			if (dpressed) {
				y += 5 + accel;
				accel += hold;
			}

		}
		if (y - boxheight / 2 > 0) {
			if (upressed) {
				y -= 5 + accel;
				accel += hold;
			}

		}

	}

	public void keyPressed(char key) {
		if (key == upk) {
			upressed = true;
			
		}
		if (key == downk) {
			dpressed = true;
		}
	}

	public void keyReleased(char key) {
		if (key == upk) {
			upressed = false;
			reset1();
		}
		if (key == downk) {
			dpressed = false;
			reset1();
		}
	}
	public float getx(){
		return x;
	}
	public float gety() {
		return y;
	}
	public float getwidth() {
		return boxwidth;
	}
	public float getheight() {
		return boxheight;
	}
	public void reset1() {
		accel = daccel;
	}

}
