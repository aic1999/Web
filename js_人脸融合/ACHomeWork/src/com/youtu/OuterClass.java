package com.youtu;

public class OuterClass {
	 class innerClass {				//ÄÚ²¿Àà
		innerClass() {	
		}
		public void inf() {
		}
		int y = 0;
	}
 
	innerClass in = new innerClass();
	public void ouf() {
		in.inf();
	}

	public innerClass doit() {
		in.y = 4;
		return new innerClass();
	}
	public static void main(String[] args) {
		OuterClass out = new OuterClass();
		OuterClass.innerClass in = out.doit();
		OuterClass.innerClass in2 = out.new innerClass();
	}
}