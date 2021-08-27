package se.nackademin.java20.lab1.client;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-27
 * Time:  13:21
 * Project: lab1-master
 * Copyright: MIT
 */
public class Risk {
	private boolean pass;

	public Risk(boolean pass) {
		this.pass = pass;
	}

	public Risk() {
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}
}
