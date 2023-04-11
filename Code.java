package Main;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

public class DescriptografiaAlternativa {
	public static void main (String[] args) throws Exception {	
	
		Scanner sc = new Scanner(System.in);
		Integer loop = 1;
		ArrayList<Object> arrayCripto = new ArrayList<Object>();
		String messagesCripto = "";
        
		for(int i = 0; i < loop;){
			messagesCripto = "";

			System.out.println("Introduza uma frase para ser criptografada:");
			String textoPlano = sc.nextLine();
					
			String cripto = Base64.getEncoder().encodeToString(textoPlano.getBytes());
			System.out.println();
			Thread.sleep(1000);
			System.out.println("Texto criptografado: " + cripto);
			
			arrayCripto.add(cripto);
			for(int j = 0; j < arrayCripto.size();j++) {
				int h = j + 1;
				messagesCripto += "\nTexto número "+ h + " -> " + arrayCripto.get(j) + ",";
			}
			messagesCripto = messagesCripto.substring(0, messagesCripto.length() - 1);
			
			System.out.println();
			Thread.sleep(1000);
			System.out.println("Deseja descriptografar sua mensagem? (S/N)");
			char question = sc.next().charAt(0);
			sc.nextLine();
					
			if (question == 'S') {
				byte[] byteDescripto = Base64.getDecoder().decode(cripto);
				String textoDescripto = new String(byteDescripto);
			
				System.out.println();
				Thread.sleep(1000);
				System.out.println("Texto descriptografado: " + textoDescripto);
			}
			
			System.out.println();
			Thread.sleep(1000);
			System.out.println("Deseja visualizar as mensagens anteriormente criptografadas? (S/N)");
			question = sc.next().charAt(0);
			sc.nextLine();
			
			if (question == 'S') {
				
				System.out.println();
				Thread.sleep(1000);
				System.out.println("Textos descriptografados anteriormente: " + messagesCripto);
			}
			
			System.out.println();
			Thread.sleep(1000);
			System.out.println("Caso deseje criptografar uma nova mensagem, basta digitar \"Sim\", caso contrário digite \"Não\". ");
			String answerLoop = sc.nextLine();
			
			if(answerLoop.equals("Não")) {
				i = 1;
			};
		}
		System.out.println("Obrigado por usar o nosso programa!");
		sc.close();
	}
}
