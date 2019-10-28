package com.xurent.keshe.model.robot;

public class InputText {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "InputText [text=" + text + "]";
	}

	public InputText(String text) {
		super();
		this.text = text;
	}

	public InputText() {
		super();
	}
	
	
}
