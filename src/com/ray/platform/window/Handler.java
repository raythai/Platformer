package com.ray.platform.window;

import java.awt.Graphics;
import java.util.LinkedList;

import com.ray.platform.framework.GameObject;
import com.ray.platform.framework.ObjectId;
import com.ray.platform.object.Block;

public class Handler {
	
	
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private GameObject tempObject;
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			tempObject = object.get(i);
			
			tempObject.tick(object);
		}
	}
	
	public void render(Graphics g){
		
		for(int i = 0; i < object.size(); i++){
			tempObject = object.get(i);
			
			tempObject.render(g);
		}
		
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	public void createLevel(){
		/*
			//floor
			for(int xx = 0; xx < Game.WIDTH*2; xx+=32)
				addObject(new Block(xx, Game.HEIGHT-32, ObjectId.Block));
			//right wall
			//for(int yy = 0; yy < Game.WIDTH+32; yy += 32)
				//addObject(new Block(Game.HEIGHT+166, yy, ObjectId.Block));
			//left wall
			for(int zz = 0; zz < Game.WIDTH+32; zz += 32)
				addObject(new Block(Game.HEIGHT-609, zz, ObjectId.Block));
			//platforms
			for(int ww = 256; ww < Game.WIDTH-256; ww+=32)
				addObject(new Block(ww, Game.HEIGHT-192, ObjectId.Block));
		*/
	}
	
}


