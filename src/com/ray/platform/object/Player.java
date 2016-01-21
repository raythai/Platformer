package com.ray.platform.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.ray.platform.framework.GameObject;
import com.ray.platform.framework.KeyInput;
import com.ray.platform.framework.ObjectId;
import com.ray.platform.framework.Texture;
import com.ray.platform.window.Animation;
import com.ray.platform.window.Game;
import com.ray.platform.window.Handler;

public class Player extends GameObject{
	
	private float width = 64, height = 56;
	
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;
	
	private Handler handler;
	
	Texture tex = Game.getInstance();
	
	private Animation playerWalk;
	private int facing = 1;
	public Player(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		
		playerWalk = new Animation(5, tex.player[1],tex.player[2],tex.player[3],tex.player[4],tex.player[5],tex.player[6]);
	}

	
	public void tick(LinkedList<GameObject> object) {
	x += velX;
	y += velY;
	
	if(velX <0) facing = -1;
	else if(velX > 0) facing = 1; 
	
	if(falling || jumping){
		velY += gravity;
		
		if(velY > MAX_SPEED)
			velY = MAX_SPEED;
		
		}
		
	Collision(object);
	
	playerWalk.runAnimation();
	}

	private  void Collision(LinkedList<GameObject> object){
		for(int i =0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Block){
				if(getBoundsTop().intersects(tempObject.getBounds())){
					y =tempObject.getY() + 39;
					velY = 0;
					
				}
				
				if(getBounds().intersects(tempObject.getBounds())){
					y =tempObject.getY() - height;
					velY = 0;
					falling = false;
					jumping = false;
				}else
					falling = true;
				}
			
				
				if(getBoundsRight().intersects(tempObject.getBounds())){
					x =tempObject.getX() - width;
				
				}
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					x =tempObject.getX() + width;
				
				}
			
			}
		}
	
	
	public void render(Graphics g) {
		
		//g.drawImage(tex.player[0],(int)x, (int)y,48, 96, null);
		
		if(jumping){
			if(facing ==1)
				g.drawImage(tex.player[7], (int)x, (int)y, null);
				else if(facing == -1)
				g.drawImage(tex.player[7],(int)x +(int)width,(int)y, -64, 56, null);
				
		}else{
			if(velX > 0){
				playerWalk.drawAnimation(g, (int)x, (int)y);
			}
			if(velX < 0){
				playerWalk.drawAnimation(g,(int)x +(int)width,(int)y, -64, 56);
			}
			if(velX == 0 ){
			
			if(facing ==1)
				g.drawImage(tex.player[0], (int)x, (int)y, null);
			else if(facing == -1)
				g.drawImage(tex.player[0],(int)x +(int)width,(int)y, -64, 56, null);	
			}
		}
		
		/*
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
		
		// for collision calculation purposes 
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsTop());
		*/
	}

	
	public Rectangle getBounds() {
		                                          //width      width                        height           width         height
		return new Rectangle((int) ((int) ((int)x+(width/2))-((width/2)/2)), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
	}
	public Rectangle getBoundsTop() {
		                                          //width      width                      width         height
		return new Rectangle((int) ((int) ((int)x+(width/2))-((width/2)/2)), (int)y, (int)width/2, (int)height/2);
		}
	
	public Rectangle getBoundsRight() {
		                                  //width                          height
		return new Rectangle((int) ((int)x+width-3), (int)y+3, (int)3, (int)height-10);
	}
	public Rectangle getBoundsLeft() {
	                                                   //height
	return new Rectangle((int)x, (int)y+3, (int)3, (int)height-10);
	}
	


}
