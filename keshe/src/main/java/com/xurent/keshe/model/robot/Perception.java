package com.xurent.keshe.model.robot;

public class Perception {

	private InputText inputText;

	public InputText getInputText() {
		return inputText;
	}

	public void setInputText(InputText inputText) {
		this.inputText = inputText;
	}

	@Override
	public String toString() {
		return "Perception [inputText=" + inputText + "]";
	}

	public Perception(InputText inputText) {
		super();
		this.inputText = inputText;
	}

	public Perception() {
		super();
	}
	
	
	
}
