package TestandoColisão;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class Jogador {
	private int x, y, xB, yB;
	private int directX, directY;
	private Image imgPlayer, imgPet;
	private ImageIcon jogadorzinho, petzinho;
	private int largura, altura;
	private String caminhoImg = "guriCima000.png";

	private boolean cima = false, baixo = false, direita = false, esquerda = false;
	
	
	public Jogador() {
		x = 100;
		y = 50;
		
		xB = x;
		yB = y;
		
		new Temporizador().start();
	}

	public void carregar() {
		jogadorzinho = new ImageIcon(caminhoImg);
		imgPlayer = jogadorzinho.getImage();
		
		petzinho = new ImageIcon("gato.png");
		imgPet = petzinho.getImage();
		
		altura = 45;
		largura = 45;

	}

	public void atualizar() {
		x += directX;
		y += directY;


		
		xB = xB;
		yB = yB;
 
	}
	


	public class timer extends Thread {

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && direita == false && esquerda == false && baixo == false) {
			cima = true;
			directY = -2;
			caminhoImg = "guriCima001.png";
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && direita == false && esquerda == false && cima == false) {
			baixo = true;
			directY = 2;
			caminhoImg = "guriBaixo001.png";

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT && direita == false && cima == false && baixo == false) {
			esquerda = true;
			directX = -2;
			caminhoImg = "guriDireita001.png";

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && cima == false && esquerda == false && baixo == false) {
			direita = true;
			directX = 2;
			caminhoImg = "guriEsquerda001.png";

		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			cima = false;
			directY = 0;
			caminhoImg = "guriCima000.png";
			carregar();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			baixo = false;
			directY = 0;
			caminhoImg = "guriBaixo000.png";
			carregar();

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			esquerda = false;
			directX = 0;
			caminhoImg = "guriEsquerda000.png";
			carregar();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			direita = false;
			directX = 0;
			caminhoImg = "guriDireita000.png";
			carregar();
		}
	}

	public class Temporizador extends Thread {
		public void run() {
			while (true) {
				System.out.print("");
				if (cima == true) {
					carregar();
					caminhoImg = "guriCima001.png";
					carregar();
					try {sleep(180);} catch (InterruptedException e) {e.printStackTrace();}
					caminhoImg = "guriCima002.png";
					carregar();
					try {sleep(180);} catch (InterruptedException e) {e.printStackTrace();}
				} else if (baixo == true) {
					caminhoImg = "guriBaixo001.png";
					carregar();
					try {sleep(180);} catch (InterruptedException e) {e.printStackTrace();}
					caminhoImg = "guriBaixo002.png";
					carregar();
					try {sleep(180);} catch (InterruptedException e) {e.printStackTrace();}
				} else if (direita == true) {
					caminhoImg = "guriDireita001.png";
					carregar();
					try {sleep(180);} catch (InterruptedException e) {e.printStackTrace();}
					caminhoImg = "guriDireita002.png";
					carregar();
					try {sleep(180);} catch (InterruptedException e) {e.printStackTrace();}
				} else if (esquerda == true) {
					caminhoImg = "guriEsquerda001.png";
					carregar();
					try {sleep(180);} catch (InterruptedException e) {e.printStackTrace();}
					caminhoImg = "guriEsquerda002.png";
					carregar();
					try {sleep(180);} catch (InterruptedException e) {e.printStackTrace();}
				}

			}

		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getXB() {
		return xB;
	}

	public int getYB() {
		return yB;
	}

	public void setX(int X) {
		this.x = X;
	}

	public void setY(int Y) {
		this.y = Y;
	}

	public void setXB(int X) {
		this.xB = X;
	}

	public void setYB(int Y) {
		this.yB = Y;
	}
	
	public Image getImgPlayer() {
		return imgPlayer;
	}
	
	public Image getImgPet() {
		return imgPet;
	}

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
	}

	public boolean isCima() {
		return cima;
	}

	public boolean isBaixo() {
		return baixo;
	}

	public boolean isDireita() {
		return direita;
	} 

	public boolean isEsquerda() {
		return esquerda;
	}
	
	

}
