package com.cs.shopper.client.entities.product;

import com.cs.shopper.client.entities.GWTSerializable;

public class ProductSize extends GWTSerializable {
	public enum Measure{
		L("l"),ML("ml"),KG("kg"),G("g"),EA("each"),BG("bag");
		private String name;
		private Measure(String name){
			this.name = name;
		}
		@Override
		public String toString(){
			return name;
			}
	};
	private String sizeID;
	private double size;
	private Measure measure;

	public ProductSize(){};
	public ProductSize(Measure measure, double size){
		setSizeID(size+measure.toString());
		setMeasure(measure);
		setSize(size);
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public Measure getMeasure() {
		return measure;
	}
	public void setMeasure(Measure measure) {
		this.measure = measure;
	}
	public String getSizeID() {
		return sizeID;
	}
	public void setSizeID(String sizeID) {
		this.sizeID = sizeID;
	}
	@Override
	public String toString(){
		return size+" "+measure.toString();
	}

}
