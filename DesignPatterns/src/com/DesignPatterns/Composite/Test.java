package com.DesignPatterns.Composite;

import java.util.ArrayList;
import java.util.Iterator;

//Replace an implicit tree structure made up
//of primitives with the Composite Pattern

//What do you do when you want to model a tree
//structure? You can either list the info as primitives
//and then search through them for what you want
//or you can create objects that represent each 
//level of the tree with the composite pattern

//This acts as an interface for every Product
//and ProductGroup that is created

abstract class ProductComponent {

	void add(ProductComponent newProductComponent) {
	}
	
	void remove(ProductComponent newProductComponent) {
	}
	
	ProductComponent getProductComponent(int componentIndex) {
		return null;
	}
	
	String getProductGroupName() {
		return null;
	}
	
	abstract void displayProductInfo();
	
}

 class ProductGroup extends ProductComponent{
	
	// Each group and all the products contained in
	// that group are stored in this ArrayList
	
	ArrayList<ProductComponent> productComponents = new ArrayList<ProductComponent>();
	
	private String productGroupName;

	public ProductGroup(String productGroupName) {
		super();
		this.productGroupName = productGroupName;
	}

	public void add(ProductComponent newProductComponent) {
		
		productComponents.add(newProductComponent);
		
	}

	public void remove(ProductComponent newProductComponent) {
		
		productComponents.remove(newProductComponent);
		
	}

	public ProductComponent getProductComponent(int componentIndex) {
		
		return (ProductComponent)productComponents.get(componentIndex);
		
	}

	public String getProductGroupName() { return productGroupName; }

	public void displayProductInfo() {
		
		System.out.println(getProductGroupName());
		
		// Cycle through and print every product in this Product Group
		
		Iterator<ProductComponent> productIterator = productComponents.iterator();
		
		while(productIterator.hasNext()){
			
			ProductComponent productInfo = (ProductComponent) productIterator.next();
			
			productInfo.displayProductInfo();
			
		}
		
		System.out.println();
		
	}

}
//Each product represents a leaf in the ProductGroup

 class Product extends ProductComponent{

	private String productName;
	private double productPrice;
	
	public Product(String productName, double productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String getProductName() { return productName;}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() { return productPrice; }

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	void displayProductInfo() {
		
		System.out.println(getProductName() + " $" + getProductPrice());
		
	}

}
public class Test {

	public static void main(String[] args){
		
		// Add product groups
		
		ProductComponent produce = new ProductGroup("Produce");
		
		ProductComponent cereal = new ProductGroup("Cereal");
		
		// Top level component that contains all products
		
		ProductComponent everyProduct = new ProductGroup("All Products\n");
		
		// Add produce and cereal groups to everyProduct list
		
		everyProduct.add(produce);
		everyProduct.add(cereal);
		
		// Add individual products to the groups
		
		produce.add(new Product("Tomato", 1.99));
		produce.add(new Product("Orange", .99));
		produce.add(new Product("Potato", .35));
		
		cereal.add(new Product("Special K", 4.79));
		cereal.add(new Product("Cheerios", 3.68));
		cereal.add(new Product("Raisin Bran", 3.68));
		
		// Display all products sorted into groups
		
		everyProduct.displayProductInfo();
		
	}
	
}

