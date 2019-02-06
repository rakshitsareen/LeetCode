package com.leetcode;

public abstract class Vehicle {
	public String color;
	public int top_speed;

	public abstract int get_top_speed();

	public void print_description() {
		System.out.println("Color : " + this.color + " and Top Speed : " + this.top_speed);
	}
}

class Car extends Vehicle {
	
	public Car(int top_speed, String color) {
		this.top_speed = top_speed;
		this.color = color;
	}
	
	@Override
	public int get_top_speed() {
		// TODO Auto-generated method stub
		return this.top_speed;
	}

}

class Plane extends Vehicle {

	public Plane(int top_speed, String color) {
		this.top_speed = top_speed;
		this.color = color;
	}

	@Override
	public int get_top_speed() {
		// TODO Auto-generated method stub
		return this.top_speed;
	}

}