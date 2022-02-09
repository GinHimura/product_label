package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> product = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int numberProducts = sc.nextInt();
		
		for(int i = 1; i <= numberProducts; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char whichProduct = sc.next().charAt(0);
			while(whichProduct != 'c' && whichProduct != 'u' 
					&& whichProduct != 'i') {
				System.out.println("Wrong command, try again");
				System.out.print("Common, used or imported (c/u/i)? ");
				whichProduct = sc.next().charAt(0);		
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(whichProduct == 'i') {
			   System.out.print("Customs fee: ");
			   double fee = sc.nextDouble();
			   product.add(new ImportedProduct(name, price, fee));
			} else if(whichProduct == 'u'){
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				product.add(new UsedProduct(name, price, date));
			} else {
				product.add(new Product(name, price));
			}
		}
		System.out.println("\nPRICE TAGS:");
		for(Product p: product) {
			System.out.println(p.priceTag());	
		}
		sc.close();
	}
}
