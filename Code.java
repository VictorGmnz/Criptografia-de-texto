package Main;

import java.util.Base64;
import java.util.Scanner;

public class DescriptografiaAlternativa {
	public static void main (String[] args) throws Exception {	
	
		Scanner sc = new Scanner(System.in);
		Integer loop = 1;
		String[] arrayCripto = {};
		String messagesCripto = "";
        
		for(int i = 0; i < loop;){

			System.out.println("Introduza uma frase para ser criptografada:");
			String textoPlano = sc.nextLine();
					
			String cripto = Base64.getEncoder().encodeToString(textoPlano.getBytes());
			System.out.println();
			Thread.sleep(1000);
			System.out.println("Texto criptografado: " + cripto);
			
			arrayCripto = new String[]{cripto};
			for(int j = 0; j < arrayCripto.length;j++) {
				messagesCripto += "\n " + arrayCripto[j] + ",";
			}
			
			System.out.println();
			Thread.sleep(1000);
			System.out.println("Deseja descriptografar sua mensagem? (S/N)");
			char question = sc.next().charAt(0);
			sc.nextLine();
					
			if (question == 'S') {
				byte[] byteDescripto = Base64.getDecoder().decode(cripto);
				String textoDescripto = new String(byteDescripto);
			
				System.out.println();
				System.out.println("Texto descriptografo: " + textoDescripto);
			}
			
			System.out.println("Deseja visualizar as mensagens anteriormente criptografadas? (S/N)");
			question = sc.next().charAt(0);
			sc.nextLine();
			
			if (question == 'S') {
				
				System.out.println();
				System.out.println("Textos descriptografados anteriormente: " + messagesCripto);
			}
			
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
