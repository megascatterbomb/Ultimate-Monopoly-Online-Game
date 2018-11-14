package com.nullPointer.Model.Square;

import com.nullPointer.Model.GameEngine;
import com.nullPointer.Model.Player;

public abstract class Square {
	private String name;
	private String type;
	
	public Square(String n,String t){
		name=n;
		type=t;
	}
	public String getName(){
		return name;
	}
	public String getType(){
		return type;
	}
	public abstract void evaluateSquare(GameEngine gameEngine);
}