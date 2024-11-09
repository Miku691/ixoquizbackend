package com.springdemo.firebase.entity;

public class QuizOptions {
	private String option_I;
	private String option_II;
	private String option_III;
	private String option_IV;
	
	
	
	public QuizOptions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuizOptions(String option_I, String option_II, String option_III, String option_IV) {
		super();
		this.option_I = option_I;
		this.option_II = option_II;
		this.option_III = option_III;
		this.option_IV = option_IV;
	}
	
	public String getOption_I() {
		return option_I;
	}
	public void setOption_I(String option_I) {
		this.option_I = option_I;
	}
	public String getOption_II() {
		return option_II;
	}
	public void setOption_II(String option_II) {
		this.option_II = option_II;
	}
	public String getOption_III() {
		return option_III;
	}
	public void setOption_III(String option_III) {
		this.option_III = option_III;
	}
	public String getOption_IV() {
		return option_IV;
	}
	public void setOption_IV(String option_IV) {
		this.option_IV = option_IV;
	}
}
