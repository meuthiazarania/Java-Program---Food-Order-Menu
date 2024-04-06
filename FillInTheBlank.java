package main;

import java.util.Scanner;

public class FillInTheBlank {

	public static void main(String[] args) {
		////Pastikan untuk membuat Scanner agar bisa input
		Scanner scan = new Scanner(System.in);
		
		int mainMenuSelection;
		int foodSelection;
		int quantity = 1, money;
		int total = 0;
		
		
		//1. validasi input menu
		do {
			System.out.println("1. Order");
			System.out.println("2. Payment");
			System.out.println("3. Reset Order");
			System.out.println("4. Exit");
			
			do {
				System.out.println("Select Menu: ");
				mainMenuSelection = scan.nextInt(); scan.nextLine();
			}  while (!(mainMenuSelection >= 1 && mainMenuSelection <= 4));
		
			switch(mainMenuSelection) {
			case 1:
				do {
					System.out.println("1. Sweet Madame | Rp 100.000");
					System.out.println("2. Mora Meat    | Rp. 45.000");
					System.out.println("3. Jade Parcels | Rp 50.000");
					System.out.println("4. Back");
					
					//2. validasi hanya boleh milih opsi angka 1-4 aja
					do {
						System.out.println("Select Menu: ");
						foodSelection = scan.nextInt(); scan.hasNextLine();
					} while (!(foodSelection >=1 && foodSelection <=4)); //! untuk negasi selama bukan nomor 1-4
				
					//jika user milih menu no. 4, maka menu makanan berhenti.
				if(foodSelection == 4) break;
				do {
					System.out.println("How many?");
					quantity = scan.nextInt(); scan.nextLine();
				} while(quantity < 1);
				
				//Menambah harga makanan
				if(foodSelection == 1)
					total += 100000 * quantity;
				else if(foodSelection == 2)
					total += 4500 * quantity;
				else if(foodSelection == 3)
					total += 50000 * quantity;
				
					System.out.println("Your order has been successfully placed!");
				} while(foodSelection != 4);
				break;
			case 2:
				//3. validasi user udah pesen makan atau belum
				if(total == 0) { //jika total order 0 (belum order sama sekali, maka akan menampilkan pesan untuk order dulu.
					System.out.println("Please make an order first!");
					break;
				} else { //kalau udah order, langsung nampilin pesan total pesanannya
					System.out.println("The total is: " + total);
					System.out.println("Enter money: ");
					money = scan.nextInt(); scan.nextLine();
					
					while(money < total) {
						System.out.println("Insufficient Money!");
						System.out.println("Enter money: ");
						money = scan.nextInt(); scan.nextLine();
					}
					System.out.println("Thank you for purchasing!");
					System.out.println("Change: Rp " + (money-total));
					
					//4. Mengapa di akhir payment nilai total harus direset jadi 0 ?
					/* jawaban: agar saat reset order, totalnya tidak tercampur 
					 * 			dengan total sebelumnya.
					 */
					total = 0;
					break;
				}
			case 3:
				System.out.println("Order has been reset");
				total = 0;
				break;
			case 4:
				System.out.println("Thank You!");
				break;
			} 
		} while (mainMenuSelection != 4);
	}
}
