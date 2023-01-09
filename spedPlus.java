import processing.core.PApplet;

public class spedPlus {
		private int current, timestamp, settime;
		private float x, y;
		private float wsize, hsize;
		private int color;
		public boolean visible;
		
		public spedPlus(float x, float y, float wsize, float hsize, int timestamp, int settime, int current, int color) {
			this.x = x;
			this.y = y;
			this.wsize = wsize;
			this.hsize = hsize; 
			this.timestamp = timestamp;
			this.settime = settime;
			this.current = current;
			this.color = color;
			
			visible = false;
		}
	
	public void draw(PApplet p) {
		if(p.millis()-timestamp >= settime) {
			p.ellipseMode(PApplet.CENTER);
			p.fill(color);
			p.ellipse(x, y, wsize, hsize);
		}
		if(p.millis() - timestamp >= settime + 4000) {
			timestamp = p.millis();
		}
	}
	
	public void update(PApplet p) {
		if(p.millis()-timestamp >= settime){
			visible = true;
		}
		//time check
			//visible set true
		if(p.millis() - timestamp < settime){
			visible = false;
		}
		//if visible
			//collision logic
	}

	public float getx1(){
		return x;
	}
	public float gety1(){
		return y;
	}
	public float getwidth1() {
		return wsize;
	}
	public float getheight1() {
		return hsize;
	}
}
