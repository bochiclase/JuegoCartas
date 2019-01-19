import java.util.Random;
import java.util.Scanner;

public class Cartas {
	
	private static String  [] baraja =  {"Picas", "Treboles", "Rombos", "Corzones"};
	
	public static  String palo () {
		int carta;
		Random r = new Random();
		carta=r.nextInt(4);
		String palo = baraja[carta];
		return palo;
		
	}
	
	
	public static int valor () {
		int valor;
		Random r = new Random();
		valor = r.nextInt(13)+1;
			
		
		return valor;
		
		
	}
	
	public static int ValorVerdadero(int peso) {
		
		
		int ValorVerdadero = peso;
		
		if (peso>1 && peso< 11 ){
			ValorVerdadero = peso;
		}
		if (peso==11) {
			ValorVerdadero = 10;
		}
		if (peso==12) {
			ValorVerdadero = 10;
		}
		if (peso==13) {
			ValorVerdadero = 10;
		}
		if (peso==1) {
			ValorVerdadero = 11;
		}
	
		return ValorVerdadero;
	}
	
	
	
	
	public static String figuras(int suma) {
		
		String figuras = ""; 
		
		if (suma>1 && suma< 11 ){
			figuras = Integer.toString(suma);
		}
		
		if (suma == 11) {
			figuras = "Principe J";
		}
		if (suma == 12) {
			figuras = "Reina Q";
		}
		if (suma == 13) {
			figuras = "Rey K";
		}
		if (suma == 1 ) {
			figuras = "AS";
		}
	
		
		return figuras;
		
	}
	

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char contestacion;
		char afi ='s';
		

	do {	
		System.out.println ("¿¿¿Quieres Jugar???"); 
        System.out.println ("Pulsa S o N");
        contestacion =sc.next().charAt(0);
        if (contestacion != afi) {
        	System.out.println("ADIOS");
        	break;
        	
        }
        else {
		//PARA JUGADOR
		int sumajugador =0;
		int resta =0;
		int pesojugador;
		int preciojugador;
		String cartajugador;
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("#################################################");
		System.out.println("TUS CARTAS SON");
		System.out.println();
		for	(int i=1; i<3;i++) {
			pesojugador = valor();
			preciojugador = ValorVerdadero(pesojugador);
			cartajugador = figuras(pesojugador);
			System.out.println("La carta es " + cartajugador + " de " + palo() + " vale " + preciojugador);
			sumajugador += preciojugador;
			resta = 21 - sumajugador;
		}
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("El valor de tus cartas es " + sumajugador);
		System.out.println("--------------------------------");
		System.out.println("Te faltan " + resta + " para BLACKJACK");
		System.out.println();
		System.out.println();
		
		
		//PARA EL CRUPIER
		int sumacrupier =0;
		int pesocrupier = valor();
		int preciocrupier = ValorVerdadero(pesocrupier);
		String cartacrupier = figuras(pesocrupier);
		System.out.println("#################################################");
		System.out.println("CARTAS DE LA BANCA");
		System.out.println();
		System.out.println("La banca muestra " + cartacrupier + " de " + palo() + " vale " + preciocrupier);
		sumacrupier += preciocrupier;
		System.out.println();
		
		if (sumajugador ==21) {
			System.out.println("HAS GANADO, QUE SUERTE TIENES BLACKJACK EN LA PRIMERA MANO");;
		}
		else {
		//Pregunta
		
		Scanner t = new Scanner(System.in);
		char letra;
		char si ='s';
		char no ='n';
		
		
		 do {
		System.out.println();
		System.out.println();
		System.out.println("¿Quieres otra carta?");
		System.out.println("Pulsa S para SI o Pulsa N para NO.   Recuerda llevas un total de " + sumajugador);
		
		letra=t.next().charAt(0);
		
		
		if ( letra == si) {
			
			pesojugador = valor();
			preciojugador = ValorVerdadero(pesojugador);
			cartajugador = figuras(pesojugador);
			System.out.println();
			System.out.println("#################################################");
			System.out.println("TUS CARTAS SON");
			System.out.println();
			System.out.println("La carta es " + cartajugador + " de " + palo() + " vale " + preciojugador);
			sumajugador += preciojugador;
			resta = 21 - sumajugador;
			System.out.println();
			System.out.println("--------------------------------");
			System.out.println("El valor de tus cartas es " + sumajugador);
			System.out.println("--------------------------------");
			System.out.println();
			if (sumajugador >21) {
				System.out.println("Lo siento te has pasado");
				System.out.println("La BANCA GANA Tu pierdes");
			} 
			
			else {
			System.out.println("Te faltan " + resta + " para BLACKJACK");
			System.out.println();
		
			}
			
		}
		 
		
		
		
		if (letra == no) {
			
			do {
			int pesocrupier2 = valor();
			int preciocrupier2 = ValorVerdadero(pesocrupier2);
			String cartacrupier2 = figuras(pesocrupier2);
			System.out.println();
			System.out.println();
			System.out.println("#################################################");
			System.out.println("CARTAS DE LA BANCA");
			System.out.println();
			System.out.println("La banca muestra " + cartacrupier2 + " de " + palo() + " vale " + preciocrupier2);
			sumacrupier += preciocrupier2;
			System.out.println("La  BANCA tiene " + sumacrupier);
			
			}while (sumacrupier<17);
			
			
			System.out.println("Tu tienes " + sumajugador);
			System.out.println();
			System.out.println();
			
			if(sumacrupier == sumajugador) {
				
				System.out.println("EMPATES");
				System.out.println();
				System.out.println();
				break;
			}
			
			if (sumacrupier<sumajugador && sumajugador<22 || sumacrupier>21 || sumajugador==21) {
				System.out.println("ENORABUENA HAS GANADO");
				System.out.println();
				System.out.println();
				break;
			}
			
			if(sumacrupier>sumajugador && sumacrupier<22 || sumacrupier == 21)
			{
				System.out.println("Lo siento has perdido, la BANCA GANA");
				System.out.println();
				System.out.println();
				break;
			}
			
		}
		if (sumajugador==21 ) {
			
			System.out.println("TIENES BLACKJACK");
			System.out.println();
			System.out.println();
			break;
		}	
		
		 }while(letra != si || letra != no);
		
	}
        }
	} while(contestacion== afi);

	}
	
}