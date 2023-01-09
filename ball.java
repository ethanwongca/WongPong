import processing.core.PApplet;

public class ball {
	private static final int purple = 0xFFA800FF;
	private static final int blue = 0xFF0079FF;
	private static final int green = 0xFF00F11D;
	private static final int yellow = 0xFFFFEF00;
	private static final int orange = 0xFFFF7F00;
	private static final int red = 0xFFFF0900;
	private static final float dspd = 5;
	private static final float daccel = 0;

	public float x, y, size, dir, spd;
	private int color = red;
	private int color1 = yellow;
	private int color2 = orange;
	private int color3 = green;
	private int color4 = blue;
	private int color5 = purple;
	private float angle;
	private float wallrandom;
	private int timeStamp, cycleTime;
	private float accel;
	private int current;
	private boolean hitbox, state;

	public ball(float size, float angle, float wallrandom, int current, int timeStamp, int cycleTime) {
		this.size = size;
		this.angle = angle;
		this.wallrandom = wallrandom;
		this.current = current;
		this.timeStamp = timeStamp;
		this.cycleTime = cycleTime;
		
		state = true;
		hitbox = true;
		reset();
	}

	public void draw(PApplet p) {
		p.noStroke();
		p.fill(color);
		p.rectMode(PApplet.CENTER);
		p.circle(x, y, size);
	}

	public void update(mainClass m, PApplet p) {
		if(accel <= 5) {
			spd = dspd + accel;
		}
		x += spd * PApplet.cos(PApplet.radians(dir));
		y += spd * PApplet.sin(PApplet.radians(dir));
		
		
		if(p.millis() - timeStamp >= cycleTime) {
			timeStamp = p.millis();
			accel ++;
		}
		
		if (y - size/2 <= 0 || y + size/2 >= mainClass.scrh) {
			dir = wallrandom - dir;
			int temp;
			temp = color;
			color = color1;
			color1 = color2;
			color2 = color3;
			color3 = color4;
			color4 = color5;
			color5 = temp;
		}
		if(x-size/2 <= 0) {
			reset();
			m.num += 1;
		}
		if(x+size/2 >= mainClass.scrw) {
			reset();
			m.num1 += 1;
		}
		
	}

	public void collision(paddle p, sugarMode s) {
		if (x - size / 2 <= p.getx() + p.getwidth() / 2 && x + size / 2 >= p.getx() - p.getwidth() / 2) {
			if (y - size / 2 <= p.gety() + p.getheight() / 2 && y + size / 2 >= p.gety() - p.getheight() / 2) {
				
					dir -= angle;
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
		if (x - size / 2 <= s.getx() + s.getsize() / 2 && x + size / 2 >= s.getx() - s.getsize() / 2) {
			if (y - size / 2 <= s.gety() + s.getsize() / 2 && y + size / 2 >= s.gety() - s.getsize() / 2) {
				
					dir -= angle;
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

	}
	public void pc(spedPlus sp, spedPlus sp1) {
		if(sp.visible == true) {
			if (x - size / 2 <= sp.getx1() + sp.getwidth1() / 2 && x + size / 2 >= sp.getx1() - sp.getwidth1() / 2) {
				if (y - size / 2 <= sp.gety1() + sp.getheight1() / 2 && y + size / 2 >= sp.gety1() - sp.getheight1() / 2) {
					x = sp1.getx1();
					y = sp1.gety1();
					x = x + sp.getwidth1() + 1;
				}
			}
		if(sp.visible == true) {	
		if (x - size / 2 <= sp1.getx1() + sp1.getwidth1() / 2 && x + size / 2 >= sp1.getx1() - sp1.getwidth1() / 2) {
			if (y - size / 2 <= sp1.gety1() + sp1.getheight1() / 2 && y + size / 2 >= sp1.gety1() - sp1.getheight1() / 2) {
				x = sp.getx1();
				y = sp.gety1();
				x = x + sp.getwidth1() + 1;
				}	
		}
		}
		}
	}

	public void reset() {
		x = mainClass.scrw / 2;
		y = mainClass.scrh / 2;
		spd = dspd;
		dir = (float) Math.random() * 360;
		accel = daccel;
		current = 0;
		hitbox = true;
		state = true;
	}

}
