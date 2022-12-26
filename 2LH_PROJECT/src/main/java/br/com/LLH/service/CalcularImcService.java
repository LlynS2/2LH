package br.com.LLH.service;

public class CalcularImcService {
	
		public float calcularImc(float peso, float altura) {
			return peso / (altura * altura);
		}
	
		public String resultadoIMC(float peso, float altura){
			
			float imcCal = calcularImc(peso,altura);
		
			String msg;
			
			if (imcCal <= 18.5) {
					msg = " Seu IMC est� a n�vel Abaixo do peso normal , vamos ficar sa�daveis !!";
				}
	
			else if (18.5 < imcCal && imcCal <= 25) {
					msg = "Parab�ns !! Seu IMC est� a n�vel Peso normal, continue assim (:";
				}
	
			else if (25 < imcCal && imcCal <= 30) {
					msg =  "Seu IMC est� a n�vel Acima do peso normal. Continue se cuidando voc� vai alcan�ar seus objetivos!!";
				}
	
			else if(imcCal > 30) {
					msg =  " Seu IMC est� a n�vel Obesidade , mas n�o desista. Voc� consegue !!";
				} 
			else { 
					msg = " Algo de errado n�o est� certo, por favor verifique seus dados novamente !!";
				}
			
			return msg;
			}
}