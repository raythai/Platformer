package com.ray.platform.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.ray.platform.framework.GameObject;
import com.ray.platform.framework.ObjectId;
import com.ray.platform.framework.Texture;
import com.ray.platform.window.Game;

public class Block extends GameObject
{
	Texture tex = Game.getInstance();
	private int type; //type of block

	public Block(float x, float y, int type, ObjectId id) {
		super(x, y, id);
		this.type = type;
	}

	
	public void tick(LinkedList<GameObject> object) {
		
		
	}

	
	public void render(Graphics g) {
	
		//g.setColor(Color.white);
		//g.drawRect((int)x,(int)y, 32, 32);
		
		if(type == 0) //dirt block
			g.drawImage(tex.block[0], (int)x, (int)y, null);
		if(type ==1) //grass block
			g.drawImage(tex.block[1], (int)x, (int)y, null);
	}


	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 32, 32);
	}

	
	

}
