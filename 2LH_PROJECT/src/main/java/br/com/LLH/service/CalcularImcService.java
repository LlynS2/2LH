package br.com.LLH.service;

public class CalcularImcService {
	
		public float calcularImc(float peso, float altura) {
			return peso / (altura * altura);
		}
	
		public String resultadoIMC(float peso, float altura){
			
			float imcCal = calcularImc(peso,altura);
		
			String msg;
			
			if (imcCal <= 18.5) {
					msg = " Seu IMC está a nível Abaixo do peso normal , vamos ficar saúdaveis !!";
				}
	
			else if (18.5 < imcCal && imcCal <= 25) {
					msg = "Parabéns !! Seu IMC está a nível Peso normal, continue assim (:";
				}
	
			else if (25 < imcCal && imcCal <= 30) {
					msg =  "Seu IMC está a nível Acima do peso normal. Continue se cuidando você vai alcançar seus objetivos!!";
				}
	
			else if(imcCal > 30) {
					msg =  " Seu IMC está a nível Obesidade , mas não desista. Você consegue !!";
				} 
			else { 
					msg = " Algo de errado não está certo, por favor verifique seus dados novamente !!";
				}
			
			return msg;
			}
}