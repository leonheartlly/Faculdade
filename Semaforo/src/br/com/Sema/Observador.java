package br.com.Sema;

import java.util.Random;

public class Observador extends Thread {

	private int num;

	public void run() {
		this.num = new Random().nextInt(100);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
