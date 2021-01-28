package ruleta;

import java.util.Random;
import java.util.Scanner;

public class ruleta {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		Random r = new Random();
		int modo = 0;

		Normas();
		modo = Modalidad(modo);

		char repetir = 'S';
		while (repetir == 'S' || repetir == 's') {

			int player = 0;
			int coin1 = 20;
			int acoin1 = 0;
			int coin2 = 20;
			int acoin2 = 0;
			int rcolor = 0;
			int par = 0;
			int apar = 0;
			int king = 0;
			char color = ' ';
			char acolor = ' ';

			if (modo == 1) {

				player = EmpiezaJugador(player);

				while (coin1 < 100 || coin1 > 1 || coin2 < 100 || coin2 > 1) {
					if (player == 1) {

						TP1(coin1, acoin1, acolor, apar);
						acoin1 = AC1(acoin1, coin1);
						coin1 = coin1 - acoin1;

						apar = AP(apar);

						TP1(coin1, acoin1, acolor, apar);

						acolor = AC(acolor);

						TP1(coin1, acoin1, acolor, apar);

					} else if (player == 2) {

						acoin2 = r.nextInt(coin2) + 1;
						coin2 = coin2 - acoin2;

						apar = r.nextInt(2) + 1;

						rcolor = r.nextInt(5) + 1;

						if (rcolor == 1 || rcolor == 2) {
							acolor = 'R';
						} else if (rcolor == 3 || rcolor == 4) {
							acolor = 'N';
						} else if (rcolor == 5) {
							acolor = 'V';
						}

						System.out.println();
						TIA(coin2, acoin2, acolor, apar);
						Thread.sleep(2000);
					}
					// RULETA
					king = ruleta(king);
					par = PR(king, par);
					color = CR(king, color);

					if (player == 1) {

						if (acolor == 'V' && color == 'V') {
							System.out.println("HAS GANADO");
							coin1 = coin1 + acoin1 * 100;
							acoin1 = 0;
						} else if (apar == par && acolor == color) {
							coin1 = coin1 + acoin1 * 2;
							acoin1 = 0;
						} else if (apar != par && acolor == color) {
							coin1 = coin1 + acoin1;
							acoin1 = 0;
						} else if (apar == par && acolor != color) {
							coin1 = coin1 + acoin1;
							acoin1 = 0;
						} else if (apar != par && acolor != color) {
							acoin1 = 0;
							acoin1 = 0;
						}

						apar = 0;
						acolor = ' ';

						System.out.println();
						TP1(coin1, acoin1, acolor, apar);

					} else if (player == 2) {

						if (acolor == 'V' && color == 'V') {
							System.out.println("HAS GANADO");
							coin2 = coin2 + acoin2 * 100;
							acoin2 = 0;
						} else if (apar == par && acolor == color) {
							coin2 = coin2 + acoin2 * 2;
							acoin2 = 0;
						} else if (apar != par && acolor == color) {
							coin2 = coin2 + acoin2;
							acoin2 = 0;
						} else if (apar == par && acolor != color) {
							coin2 = coin2 + acoin2;
							acoin2 = 0;
						} else if (apar != par && acolor != color) {
							acoin2 = 0;
							acoin2 = 0;
						}

						apar = 0;
						acolor = ' ';
						System.out.println();
						TIA(coin2, acoin2, acolor, apar);

					}

					player = CP(player);
				}
			} else if (modo == 2) {

				player = EmpiezaJugador(player);

				while (coin1 < 100 || coin1 > 1 || coin2 < 100 || coin2 > 1) {
					if (player == 1) {

						TP1(coin1, acoin1, acolor, apar);

						acoin1 = AC1(acoin1, coin1);
						coin1 = coin1 - acoin1;

						apar = AP(apar);

						TP1(coin1, acoin1, acolor, apar);

						acolor = AC(acolor);

						System.out.println();
						TP1(coin1, acoin1, acolor, apar);

					} else if (player == 2) {

						TP2(coin2, acoin2, acolor, apar);

						acoin2 = AC2(acoin2, coin2);
						coin2 = coin2 - acoin2;

						apar = AP(apar);

						TP2(coin2, acoin2, acolor, apar);

						acolor = AC(acolor);

						System.out.println();
						TP2(coin2, acoin2, acolor, apar);
					}
					// RULETA
					king = ruleta(king);
					par = PR(king, par);
					color = CR(king, color);

					if (player == 1) {
						if (acolor == 'V' && color == 'V') {
							System.out.println("HAS GANADO");
							coin1 = coin1 + acoin1 * 100;
							acoin1 = 0;
						} else if (apar == par && acolor == color) {
							coin1 = coin1 + acoin1 * 2;
							acoin1 = 0;
						} else if (apar != par && acolor == color) {
							coin1 = coin1 + acoin1;
							acoin1 = 0;
						} else if (apar == par && acolor != color) {
							coin1 = coin1 + acoin1;
							acoin1 = 0;
						} else if (apar != par && acolor != color) {
							acoin1 = 0;
							acoin1 = 0;
						}

						apar = 0;
						acolor = ' ';
						System.out.println();
						TP1(coin1, acoin1, acolor, apar);

					} else if (player == 2) {
						if (acolor == 'V' && color == 'V') {
							System.out.println("HAS GANADO");
							coin2 = coin2 + acoin2 * 100;
							acoin2 = 0;
						} else if (apar == par && acolor == color) {
							coin2 = coin2 + acoin2 * 2;
							acoin2 = 0;
						} else if (apar != par && acolor == color) {
							coin2 = coin2 + acoin2;
							acoin2 = 0;
						} else if (apar == par && acolor != color) {
							coin2 = coin2 + acoin2;
							acoin2 = 0;
						} else if (apar != par && acolor != color) {
							acoin2 = 0;
							acoin2 = 0;
						}

						apar = 0;
						acolor = ' ';
						System.out.println();
						TP2(coin2, acoin2, acolor, apar);
					}

					player = CP(player);
				}

			}
			System.out.println("Quieres volver a jugar?		Si - S		No - N");
			repetir = teclado.next().charAt(0);

			while (repetir != 'S' || repetir != 'N') {
				System.out.println("Si - S		No - N??????");
				repetir = teclado.next().charAt(0);
			}
		}

	}

	public static void Normas() throws InterruptedException {
		System.out.println("		BIENVENIDO AL JUEGO DE LA RULETA!  \n");
		Thread.sleep(2 * 1000);

		System.out.println(" -Empiezas con 20 coins y tienes que seleccionar un color y una paridad."
				+ "\n -Los números son del 1 al 36."
				+ "\n -Los colores son Rojo(R) Negro(N) y Verde(V) el cual es el color ganador."
				+ "\n -Si aciertas el color entre el negro o el rojo la cantidad apostada se multiplica X1."
				+ "\n -Si ademas de acertar el color, aciertas la paridad, la cantidad apostada se multiplicara X2."
				+ "\n -Si da la casualidad que apuestas al color verde y te toca, automaticamente has ganado la partida. \n");
		Thread.sleep(1 * 1000);
		System.out.println("REGLAS");
		Thread.sleep(1 * 500);
		System.out.println("Tienes que apostar como minimo 1 coin.");
		Thread.sleep(1 * 500);
		System.out.println("Tienes que apostar 1 color y una paridad obligatoriamente. \n");
	}

	public static int Modalidad(int modo) throws InterruptedException {

		Scanner teclado = new Scanner(System.in);

		Thread.sleep(3 * 1000);
		System.out.println("Que Modalidad quieres jugar?	1- Player Vs IA		2- Player Vs Player");
		modo = teclado.nextInt();

		while (modo < 1 || modo > 2) {
			System.out.println("Modalidad de juego incorrecta, por favor vuelva a introducir la modalidad");
			modo = teclado.nextInt();
		}
		return modo;
	}

	public static int EmpiezaJugador(int player) throws InterruptedException {

		Random r = new Random();
		System.out.println(
				"Vamos a decidir aleatoriamente quien va a empezar, tu eres el PLAYER 1 y la IA sera el PLAYER 2:\n");
		player = r.nextInt(2) + 1;

		Thread.sleep(1000);

		System.out.println("Va a empezar el Player: " + player);
		Thread.sleep(500);
		System.out.println("EMPECEMOS!! \n");
		Thread.sleep(1000);
		return player;
	}

	public static void TP1(int coin1, int acoin1, char acolor, int apar) throws InterruptedException {
		System.out.println("Coins Player 1:  " + coin1);
		System.out.println("Cantidad apostada:  " + acoin1);
		System.out.println("COLOR seleccionado:  " + acolor);
		System.out.println("PARIDAD seleccionada:  " + apar);
		Thread.sleep(1000);
	}

	public static void TP2(int coin2, int acoin2, char acolor, int apar) throws InterruptedException {
		System.out.println("Coins Player 2:  " + coin2);
		System.out.println("Cantidad apostada:  " + acoin2);
		System.out.println("Color seleccionado:  " + acolor);
		System.out.println("PARIDAD seleccionada:  " + apar);
		Thread.sleep(1000);
	}

	public static void TIA(int coin2, int acoin2, char acolor, int apar) throws InterruptedException {
		System.out.println("Coins IA:  " + coin2);
		System.out.println("Cantidad apostada:  " + acoin2);
		System.out.println("Color seleccionado:  " + acolor);
		System.out.println("PARIDAD seleccionada:  " + apar);
		Thread.sleep(1000);

	}

	public static int AC1(int acoin1, int coin1) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Cuantos coins vas a apostar?");
		acoin1 = teclado.nextInt();

		while (acoin1 < 1 || acoin1 > coin1) {
			System.out.println("Por favor, introduce una apuesta permitida.");
			acoin1 = teclado.nextInt();
		}
		return acoin1;
	}

	public static int AC2(int acoin2, int coin2) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("\n Cuantos coins vas a apostar?");
		acoin2 = teclado.nextInt();

		while (acoin2 < 1 || acoin2 > coin2) {
			System.out.println("\n Por favor, introduce una apuesta permitida.");
			acoin2 = teclado.nextInt();
		}
		return acoin2;
	}

	public static int AP(int apar) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("A que paridad vas a apostar?  1-PAR   2-IMPAR");
		apar = teclado.nextInt();

		while (apar < 1 || 2 < apar) {
			System.out.println("Por favor, introduce una paridad permitida.");
			apar = teclado.nextInt();
		}
		return apar;
	}

	public static char AC(char acolor) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("\n A que color apuestas?" + "\n	R- Rojo" + "\n	N- Negro" + "\n	V- Verde \n");
		acolor = teclado.next().charAt(0);
		return acolor;
	}

	public static int ruleta(int king) throws InterruptedException {
		Random r = new Random();
		System.out.println("\n EMPIEZA A RODAR LA RULETA");
		Thread.sleep(2000);

		king = r.nextInt(36) + 1;
		System.out.println("\nEl numero ganador ha sido:  " + king);
		return king;
	}

	public static int PR(int king, int par) {
		if (king % 2 == 0) {
			System.out.println("Es PAR");
			par = 1;
		} else {
			System.out.println("Es IMPAR");
			par = 2;
		}
		return par;
	}

	public static char CR(int king, char color) {

		if (king == 1 || king == 3 || king == 5 || king == 7 || king == 9 || king == 12 || king == 14 || king == 16
				|| king == 18 || king == 19 || king == 21 || king == 23 || king == 25 || king == 27 || king == 30
				|| king == 32 || king == 34) {
			System.out.println("Es de color ROJO (R)");
			color = 'R';

		} else if (king == 36) {
			System.out.println("Es de color VERDE (V)");
			color = 'V';

		} else {
			System.out.println("Es de color NEGRO (N)");
			color = 'N';
		}
		return color;
	}

	public static int CP(int player) {
		if (player == 1) {
			player = 2;
		} else if (player == 2) {
			player = 1;
		}
		System.out.println("\n CAMBIO DE JUGADOR   \n \n");
		return player;
	}
}