package com.rajmevada.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="PizzaTown",namespace="www.pizza.com")
public class Pizza {
	
	private String name;
	private String flavor;
	private List<String> toppings = new ArrayList<String>();

	public String getName() {
		return name;
	}

	@XmlElement(name="PizzeriaName")
	public void setName(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return flavor;
	}

	@XmlElement(name="YouCanTaste")
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public List<String> getToppings() {
		return toppings;
	}

	@XmlElement(name="topping",namespace="www.abc.com",required=true)
	public void setToppings(List<String> toppings) {
		this.toppings = toppings;
	}

	public Pizza(String name, String flavor, List<String> toppings) {
		super();
		this.name = name;
		this.flavor = flavor;
		this.toppings = toppings;
	}

	public Pizza() {
		// TODO Auto-generated constructor stub
	}
	  public Pizza(String name){
	        this.name = name;
	        this.flavor = "spicy";
	        this.toppings.add("Cheese");
	        this.toppings.add("bakon");
	    }
}
