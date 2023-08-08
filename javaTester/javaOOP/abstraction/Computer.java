package javaOOP.abstraction;

public abstract class Computer {
	// non-abstract (Normal)
	public void showCPU() {
		System.out.println("Intel");
	}

	// Abstract
	public abstract void setRam();
}
