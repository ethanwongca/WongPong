import processing.core.PApplet;

public class sugarMode {
	private float x = mainClass.scrw/2;
	private float y = mainClass.scrh/2;
	public int size = 30;
	private float spd, dir;
	private int color;
	private int current, timestamp, settime;
	private boolean grown;

	
	
	public sugarMode(float spd, float dir, int color, int current, int timestamp, int settime) {
		this.spd = spd;
		this.dir = dir;
		this.color = color;
		this.current = current;
		this.timestamp = timestamp;
		this.settime = settime;
		
		
		grown = true;
		reset();

	}


	public void draw(PApplet p) {
		p.rectMode(PApplet.CENTER);
		p.fill(color);

		p.square(x, y, size);
	}

	public void update(PApplet p, paddle p1, ball b) {
		x += spd * PApplet.cos(PApplet.radians(dir));
		y += spd * PApplet.sin(PApplet.radians(dir));
		
		if(x <= 0 || y <= 0 || x>= mainClass.scrw || y >= mainClass.scrh) {
			x = mainClass.scrw / 2;
			y = mainClass.scrh/ 2;
			reset();
		}
		if(x - size / 2 <= p1.getx() + p1.getwidth() /2 && x + size /2 >= p1.getx() - p1.getwidth()/2) {
			if(y - size/2<= p1.gety()+ p1.getheight()/2 && y + size/2 >= p1.gety() - p1.getheight()/2) {
				x = mainClass.scrw / 2;
				y = mainClass.scrh/ 2;
				reset();
			}
		if(b.x - b.size/2 <= 0) {
			reset1();
			}
		if(b.x + b.size/2 >= mainClass.scrw) {
			reset1();
			}
			}
		if(size <= 50 && grown == true) {
			if(p.millis() - timestamp >= settime) {
				timestamp = p.millis();
				size ++;
			}
		if(size == 50) {
			grown = false;
		}
		if(size == 50) {
			if(p.millis() - timestamp >= settime) {
				timestamp = p.millis();
				size -=1;
			}
		if(size == 30) {
			grown = true;
		}
		}
		}
	}
	public void reset1() {
		size = 30;
		grown = true;
	}

	public void reset() {
		dir = (float)(Math.random()*360);
	}
	public float getx(){
		return x;
	}
	public float gety() {
		return y;
	}
	public float getsize() {
		return size;
	}

}
