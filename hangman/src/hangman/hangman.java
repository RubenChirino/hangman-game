package hangman;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class Hangman {

	public static void main(String[] args) {
		
		/* ==== DATOS ==== */
		String [][] palabras = {
				{"a", "n", "t", "i", "d", "o", "t", "o"},
				{"o", "r", "e", "g", "a", "n", "o"},
				{"o", "s", "o"},
				{"t", "e", "r", "a", "p", "i", "a"},
				{"a", "g", "u", "d", "o"},
				{"g", "a", "l", "a", "x", "i", "a"},
				{"f", "i", "j", "o"},
				{"h", "i", "g", "i", "e", "n", "e"},
				{"d", "o", "c", "u", "m", "e", "n", "t", "o"},
				{"c", "o", "n", "o"},
				{"b", "r", "i", "l", "l", "a", "n", "t", "e"},
				{"j", "a", "v", "a"},
				{"g", "e", "o", "g", "r", "a", "f", "i", "a"},
				{"s", "o", "n", "i", "d", "o"},
				{"v", "i", "s", "i", "o", "n"},
				{"c", "a", "s", "t", "o", "r"},
				{"m", "o", "s", "c", "a"},
				{"p", "o", "b", "l", "a", "r"},
				{"m", "e", "s", "s", "i"},
				{"o", "i", "d", "o"},
				{"c", "a", "l", "a", "m", "a", "r"},
				{"t", "r", "a", "m", "p", "o", "z", "o"},
				{"l", "e", "j", "a", "n", "i", "a"},
				{"d", "i", "a", "m", "e", "t", "r", "o"},
				{"a", "l", "c", "a", "n", "c", "e"},
				{"t", "e", "m", "p", "l", "e"},
				{"r", "i", "t", "m", "o"},
				{"o", "d", "i", "o", "s", "o"},
				{"u", "r", "a", "n", "i", "o"},
				{"c", "i", "r", "c", "u", "i", "t", "o"},
				{"m", "e", "n", "t", "i", "r"},
				{"c", "o", "d", "i", "f", "i", "c", "a", "r"},
				{"a", "s", "f", "i", "x", "i", "a"},
				{"m", "a", "l", "v", "a", "d", "o"},
				{"t", "e", "r", "r", "a", "c", "o", "t", "a"},
				{"c", "o", "s", "m", "o"},
				{"l", "u", "p", "a"},
				{"a", "l", "g", "o", "r", "i", "t", "m", "o"},
				{"g", "r", "i", "l", "l", "a"},
				{"e", "n", "r", "e", "d", "a", "d", "o"},
				{"s", "e", "s", "g", "o"},
				{"p", "e", "l", "e", "a", "d", "o"},
		};
		// System.out.println("Total palabras en la lista a adivinar: " + palabras.length);
		
		String volverAJugar = "";
		int cantJuegosJugados = 0;
		int [] posicionPalabrasAdivinadasArray = new int[15];
	
		/* ===== JUEGO ==== */
		do {
			// DEFINICIONES
			int posicionPalabraAdivinar, cantIntentos, numeroRonda = 1;
			boolean buscarOtraPalabra = false;
			
			if (volverAJugar == "") {
				posicionPalabraAdivinar = (int)(Math.random() * palabras.length);
			} else {
				do {
					posicionPalabraAdivinar = (int)(Math.random() * palabras.length);
					// Es una nueva palabra a adivinar 
					buscarOtraPalabra = false;
					for (int i = 0; i < posicionPalabrasAdivinadasArray.length; i++) {
						if (posicionPalabrasAdivinadasArray[i] == posicionPalabraAdivinar) { 
							buscarOtraPalabra = true;
						} 
					}
					
				} while (buscarOtraPalabra);
			}
			
			switch (palabras[posicionPalabraAdivinar].length) {
			case 1:
			case 2:
			case 3:
				cantIntentos = 2;
				break;
				
			case 4:
			case 5:
			case 6:
				cantIntentos = 4;
				break;
				
			default:
				cantIntentos = 6;
				break;
			}
			
			/* if (palabras[posicionPalabraAdivinar].length <= 3) {
				cantIntentos = 2;
			} else if (palabras[posicionPalabraAdivinar].length <= 6) {
				cantIntentos = 4;
			} else  {
				cantIntentos = 6;
			} */
			
			String palabraAdivinar = "";
			String [] palabraMostrar = new String[palabras[posicionPalabraAdivinar].length];
			String [] palabrasIngresadasArray = new String[15];
			String palabrasIngresadasString = "";
			boolean ganador = false;
			
			// Unir palabra a adivinar
			for (int i = 0; i < palabras[posicionPalabraAdivinar].length; i++) {
				palabraAdivinar += palabras[posicionPalabraAdivinar][i];
				palabraMostrar[i] = "_ ";
			}
					
			if (volverAJugar == "") {
				// Mensaje bienvenida 
				String explicacionString = 
					"El juego funciona de la siguiente manera:" + "\n"
					+ "Se le asignar� una palabra a adivinar y dependiendo de la longitud de la misma tendr� una cantidad de intentos." + "\n"
					+ "Ganas al completar todos los espacios '_' de la palabra que te toc�." + "\n"
					+ "Pierdes cuando se te acaban todos los intentos para la palabra que te toc�."; 
				
				JOptionPane.showMessageDialog(null, 
						"                     ********    Welcome to the Hangman Game  ********" + "\n\n"
						+ explicacionString + "\n\n"
						+ "�Gracias y suerte!",
						"�El ahorcado!",
						JOptionPane.DEFAULT_OPTION, 
						new ImageIcon(Hangman.class.getResource("/img/juego-ahorcado-icono.png"))
				);
			}

			/* Informacion del Juego */
			System.out.println("Posicion de Palabra a Adivinar: " + posicionPalabraAdivinar);
			System.out.println("Longitud de Palabra a Adivinar: " + palabras[posicionPalabraAdivinar].length);
			System.out.println("Palabra: " + palabraAdivinar);
			System.out.println("Cantidad de intentos: " + cantIntentos);
			
			while (cantIntentos > 0 && !ganador) {			
				// Palabra a mostrar (ARRAY to STRING)
				String palabraMostrarString = "";
				for (int i = 0; i < palabras[posicionPalabraAdivinar].length; i++) {
					palabraMostrarString += palabraMostrar[i];
				}
				
				String palabrasIngresadasInformacion = "";
				
				// System.out.println("palabrasIngresadasString length: " + palabrasIngresadasString.length());
				if(palabrasIngresadasString != "") {
					palabrasIngresadasInformacion = "Palabras ingesadas: " + palabrasIngresadasString + "\n"; 
				} 
				
				String informacionRonda = palabrasIngresadasInformacion 
										  + "Cantidad de intentos restantes: " + cantIntentos + "." + "\n\n";
	
				String letraUsuario = (String) JOptionPane.showInputDialog(null,
						"         ********    �Adivina la Palabra!  ********" + "\n\n"
						+ palabraMostrarString + "\n"
						+ informacionRonda					
						+ "Ingrese una letra",
						"�El ahorcado!",
						JOptionPane.DEFAULT_OPTION,
						new ImageIcon(Hangman.class.getResource("/img/ahorcado" + cantIntentos + ".png")),
						null,
						null
				);
				
				// ===== COMPROBACION =====
				// Si est� ingresando una letra repetida
				boolean letraRepetida = false;
				for (int i = 0; i < palabrasIngresadasArray.length; i++) {
					if (letraUsuario.equalsIgnoreCase(palabrasIngresadasArray[i])) {
						// System.out.println("Repetida. Letra Usuario: " + letraUsuario + " letra ingresada antes: " + palabrasIngresadasArray[i]);
						letraRepetida = true;
					}
				}
				
				if (!letraRepetida) {
					// Si adivin� una letra
					boolean letraEncontrada = false;
					ganador = true;
					for (int i = 0; i < palabras[posicionPalabraAdivinar].length; i++) {
						if (letraUsuario.equalsIgnoreCase(palabras[posicionPalabraAdivinar][i])) {
							palabraMostrar[i] = palabras[posicionPalabraAdivinar][i];
							// System.out.println("Encontrada. Letra Usuario: " + letraUsuario + " Letra de palabra Adivinar: " + palabras[posicionPalabraAdivinar][i]);
							letraEncontrada = true;				
						}
						// Gano?
						if (palabraMostrar[i] == "_ ") {
							ganador = false;
						}
					}
					
					if (!letraEncontrada) {
						cantIntentos-= 1;
					}
					
					// Definir valores
					palabrasIngresadasArray[numeroRonda] = letraUsuario;
					palabrasIngresadasString += letraUsuario + " ";
					numeroRonda += 1; 
				} else {
					JOptionPane.showMessageDialog(null, 
							"    ********    Mensaje informativo  ********" + "\n\n"
							+ "Por favor no ingreses letras repetidas." + "\n\n"
							+ "Gracias.",
							"�El ahorcado!",
							JOptionPane.DEFAULT_OPTION, 
							new ImageIcon(Hangman.class.getResource("/img/advertencia-icono.png"))
					);
				}
				
			}
			
			if (ganador) {
				JOptionPane.showMessageDialog(null, 
						"    ********    �Ganaste!  ********" + "\n\n"
						+ "Has logrado completar la palabra asignada." + "\n\n"
						+ "�Gracias por jugar!",
						"�El ahorcado!",
						JOptionPane.DEFAULT_OPTION, 
						new ImageIcon(Hangman.class.getResource("/img/ganador.jpg"))
				);
				posicionPalabrasAdivinadasArray[cantJuegosJugados] = posicionPalabraAdivinar;
			} else {
				JOptionPane.showMessageDialog(null, 
						"    ********    �Perdiste!  ********" + "\n\n"
						+ "Puedes volver a jugar y seguir intentandolo." + "\n\n"
						+ "�Gracias por jugar!",
						"�El ahorcado!",
						JOptionPane.DEFAULT_OPTION, 
						new ImageIcon(Hangman.class.getResource("/img/ahorcado" + cantIntentos + ".png"))
				);
			}
			
			cantJuegosJugados += 1;
			
			// Volver a Jugar
			volverAJugar = (String) JOptionPane.showInputDialog(null,
					"                        ********   Volver a jugar   ********" + "\n\n"
					+ "�Quiere volver a jugar?" + "\n\n"
					+ "Ingrese 'si' para volver a jugar �" + "\n"
					+ "En caso de no querer ingrese cualquier caracter",
					"�El ahorcado!",
					JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Hangman.class.getResource("/img/ahorcado-pizarra.png")),
					null,
					null
				);
			
		} while (volverAJugar.equalsIgnoreCase("si"));
		
		JOptionPane.showMessageDialog(null, 
				"    ********    �Gracias por jugar!  ********" + "\n\n"
				+ "Espero que halla disfrutado del juego." + "\n\n"
				+ "Cantidad de partidas jugadas: " + cantJuegosJugados + ".",
				"�El ahorcado!",
				JOptionPane.DEFAULT_OPTION, 
				new ImageIcon(Hangman.class.getResource("/img/gracias.gif"))
		);
	
	}

}
