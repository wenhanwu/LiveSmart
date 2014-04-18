package com.mss.livesmart.entities;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
	private int age;
	private String gender;
	private double height;
	private List<Weight> weight=new ArrayList<Weight>() ;
	private boolean hypertension;
	private boolean diabetes;
	private boolean insomnia;
	private boolean cardio;

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public List<Weight> getWeight() {
		return weight;
	}

	public void setWeight(List<Weight> weight) {
		this.weight = weight;
	}

	public boolean isHypertension() {
		return hypertension;
	}

	public void setHypertension(boolean hypertension) {
		this.hypertension = hypertension;
	}

	public boolean isDiabetes() {
		return diabetes;
	}

	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}

	public boolean isInsomnia() {
		return insomnia;
	}

	public void setInsomnia(boolean insomnia) {
		this.insomnia = insomnia;
	}

	public boolean isCardio() {
		return cardio;
	}

	public void setCardio(boolean cardio) {
		this.cardio = cardio;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}