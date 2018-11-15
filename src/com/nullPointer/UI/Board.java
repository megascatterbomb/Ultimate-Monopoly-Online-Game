package com.nullPointer.UI;
import javax.imageio.ImageIO;
import javax.swing.*;
import com.nullPointer.Utils.ColorSet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Board extends JPanel implements Runnable{
	private BufferedImage image; 
	private File imageSrc = new File("./assets/ultimate_monopoly.png");

	private Color color = new Color(187, 229, 206);
	private Point position = new Point(10,10);
	private int length = 700;
	private int width, height;

	private int[] lastXPositions=new int[12];
	private int[] lastYPositions=new int[12];

	public Board(Point position, int length) {
		try {
			image = ImageIO.read(imageSrc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.position = position;
		this.length = length;
		width = image.getWidth(null);
		height = image.getHeight(null);

		setPreferredSize(new Dimension(length,length));
		lastXPositions[0]=14*58;
		lastYPositions[0]=14*58;
	}

	public void paint(Graphics g) {
		//g.setColor(color);
		//g.fillRect(position.x, position.y, length, length);
		g.drawImage(image, position.x, position.y, length, length, null);
		g.setColor(Color.RED);
		g.fillOval(lastXPositions[0], lastYPositions[0], 20, 20);

	}
	public void move(int amount) throws InterruptedException{
		while(amount>0){	
			if(lastXPositions[0]>4*58 && lastYPositions[0]==14*58){
				for(int j=0;j<58;j++){
					lastXPositions[0]--;
					this.repaint();
					Thread.sleep(10);
				}
				amount--;
				Thread.sleep(100);
			}
			//breaking point
			else if(lastXPositions[0]==4*58 && lastYPositions[0]==14*58){
				lastYPositions[0]--;
				for(int j=0;j<58-1;j++){
					lastYPositions[0]--;
					this.repaint();
					Thread.sleep(10);
				}
				amount--;
				Thread.sleep(100);
			}
			else if(lastXPositions[0]==4*58 && lastYPositions[0]<14*58 && lastYPositions[0]>4*58){
				for(int j=0;j<58;j++){
					lastYPositions[0]--;
					this.repaint();
					Thread.sleep(10);
				}
				amount--;
				Thread.sleep(100);
			}
			//breaking point
			else if(lastXPositions[0]==4*58 && lastYPositions[0]==4*58){
				lastXPositions[0]++;
				for(int j=0;j<58-1;j++){
					lastXPositions[0]++;
					this.repaint();
					Thread.sleep(10);
				}
				amount--;
				Thread.sleep(100);
			}
			else if(lastXPositions[0]>4*58 && lastXPositions[0]<14*58 && lastYPositions[0]==4*58){
				for(int j=0;j<58;j++){
					lastXPositions[0]++;
					this.repaint();
					Thread.sleep(10);
				}
				amount--;
				Thread.sleep(100);
			}
			//breaking point
			else if(lastXPositions[0]==14*58 && lastYPositions[0]==4*58){
				lastYPositions[0]++;
				for(int j=0;j<58-1;j++){
					lastYPositions[0]++;
					this.repaint();
					Thread.sleep(10);
				}
				amount--;
				Thread.sleep(100);
			}
			else if(lastXPositions[0]==14*58 && lastYPositions[0]>4*58){
				for(int j=0;j<58;j++){
					lastYPositions[0]++;
					this.repaint();
					Thread.sleep(10);
				}
				amount--;
				Thread.sleep(100);
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
				move(3);
			} catch (InterruptedException e) {
				System.out.println("Program Interrupted");
				System.exit(0);
			}
			repaint();
		}

	}
}