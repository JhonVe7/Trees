package PublicParckingProject;

import Trees.*;

import java.io.*;

public class Main {

	public static BinaryTree clients = new BinaryTree();

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BinaryTree bt = new BinaryTree();

	// Menu principal - String
	public static String menu() {
		String menu = "*************************************************" + "\n Seleccione alguna"
				+ " de las siguientes opciones:\n\n1) Ingreso del vehiculo"
				+ "\n2) Salida del vehiculo \n3) Lista de vehiculos alojados"
				+ "\n4) lista salidas recientes de vehiculos \n5) Reporte de accidentes" + "\n6) Salir del programa\n";
		return menu;
	}

	// Method that insert a new client.
	public static void insert_Vehicle() {
		// String name, String vehiculo , String placa, int HoraIn.
		try {

			bw.write("A continuacion diligencie la informacion del Vehiculo.\nNombre Cliente: ");
			bw.flush();
			String name = br.readLine();

			bw.write("Marca del Vehiculo: ");
			bw.flush();
			String vehiculo = br.readLine();

			bw.write("placa: ");
			bw.flush();
			String placa = br.readLine();

			bw.write("Hora de ingreso: ");
			bw.flush();
			String HoraIn = br.readLine();

			clients.insert(new BinaryNodeExample(name, vehiculo, placa, HoraIn));

		} catch (Exception ex) {
		}
	}

	// Method that delete a client.

	public static void exit_Vehicle() {
		try {
			bw.write("A continuacion digite la placa del vehiculo para su salida." + "\n");
			bw.flush();
			String placa = br.readLine();

			bw.write("Ingrese la hora de salida: ");
			bw.flush();
			String HoraOut = br.readLine();
			String HoraIn = "1:30";
			double pay = payOfService(HoraOut, HoraIn);

			bw.write("Hora de salida: " + HoraOut + "\n");
			bw.flush();

			bw.write("Total a pagar: " + pay + "\n");
			bw.flush();

			clients.delete(new BinaryNodeExample(placa));
			bw.write("El cliente de placas " + placa + " ha salido.\n");

			bw.flush();
		} catch (Exception ex) {
		}

	}

	// method that return the cost of the parking
	public static double payOfService(String horaIn, String horaOut) {
		double pay = 0.0;
		String hi[] = horaIn.split(":");
		String ho[] = horaOut.split(":");
		pay = (Integer.parseInt(hi[0]) - Integer.parseInt(ho[0])) * 6300;

		if (Integer.parseInt(hi[1]) < Integer.parseInt(ho[1]))
			pay = pay + (Integer.parseInt(hi[1]) - Integer.parseInt(ho[1]) * 0.59);

		return pay;
	}

	

	// Method that has the exit clients
	public static void OutCVehicle() {

		try {

			bw.write("A continuacion diligencie la informacion de la solicitud.\nID: ");
			bw.flush();
			String id = br.readLine();

			bw.write("Fecha (DD/MM/AAAA): ");
			bw.flush();
			String date = br.readLine();

			bw.write("Descripcion: ");
			bw.flush();
			String text = br.readLine();

		} catch (Exception ex) {
		}
	}

	// Method that returns all the clients inside the parking lot
	public static void get_Clientlist() {
		try {

		} catch (Exception e) {
		}
	}

	public static void save_Clients() {

		try {

			FileWriter fw_students = new FileWriter("Students.umd");
			BufferedWriter bw_students = new BufferedWriter(fw_students);

			BinaryNodeExample temp = (BinaryNodeExample) clients.root;

			while (temp != null) {

				bw_students.write(temp.toString());
				temp = (BinaryNodeExample) temp.getRight();
			}

			bw_students.flush();

		} catch (Exception ex) {
		}

	}

	public static void load_Clients() {

		try {

			FileReader fr_Vehicles = new FileReader("Vehicles.txt");
			BufferedReader br_Vehicles = new BufferedReader(fr_Vehicles);

			String input = br_Vehicles.readLine();
			String[] data;

			while (input != "") {

				data = input.split("\t");

				clients.insert(new BinaryNodeExample(data[0].split(" ")[1], data[1].split(" ")[1],
						data[2].split(" ")[1], data[3].split(" ")[1]));

				input = br_Vehicles.readLine();
			}

		} catch (Exception ex) {
		}
	}

	public static void main(String[] args) {

		int menu_option;
		load_Clients();
		clients.inorder(bt.root);
		;

		try {

			FileWriter fw = new FileWriter("Vehicles.txt");
			BufferedWriter bwf = new BufferedWriter(fw);

			bw.write("\nBienvenido al software de aparcamientos publicos\n");

			bw.flush();

			clients.insert(new BinaryNodeExample("luis", "nissan", "efg143", "1:31"));
			clients.insert(new BinaryNodeExample("andrea", "chevrolet", "dbq428", "1:32"));
			clients.insert(new BinaryNodeExample("ana", "bmw", "afc353", "2:30"));
			clients.insert(new BinaryNodeExample("carlos", "toyota", "afc451", "3:00"));
			clients.insert(new BinaryNodeExample("tomas", "chevrolet", "ab2133", "3:40"));
			do {

				bw.write(menu());
				bw.flush();
				menu_option = Integer.parseInt(br.readLine());

				while (menu_option > 6) {
					bw.write("Por favor, seleccione una opcion valida.\n");
					bw.flush();
					menu_option = Integer.parseInt(br.readLine());
				}

				switch (menu_option) {

				case 1:
					insert_Vehicle();
					break;
				case 2:
					exit_Vehicle();
					break;
				case 3:
					clients.inorder(bt.root);
					;
					break;
				case 4:

					break;
				case 5:
					break;
				case 6:
					bw.write("* Gracias por usar el software de aparcamiento publico. *");
					bw.flush();
					break;
				}
			} while (menu_option != 6);

			save_Clients();

		} catch (Exception ex) {
		}

	}

}