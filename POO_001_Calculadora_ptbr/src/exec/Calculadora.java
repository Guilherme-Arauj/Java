package exec;

public class Calculadora {
	
	double numA;
	double numB;
	
	Double soma(){
		double soma = numA + numB;
		return soma;
	}
	
	Double sub(){
		return numA - numB;
	}
	
	Double div(){
		return numA / numB;
	}
	
	Double mult(){
		return numA * numB;
	}
	
	Boolean verificarPrimo(int n){
        if(n <= 1){
            return false;
        } else if((n != 2) && (n % 2 == 0)){
            return false;
        }

        for(int i = 3; i< n; i+=2){
            if(n % i == 0){
                return false;
            }
        }

        return true;

	}
	
	Double potencia() {
		if (numB == 0){
			return 1.0;
		} else if(numB > 0){
			double resultado = 1;
			for(int i = 0; i < numB; i++) {
				resultado *= numA;
			}
			return resultado;
		} else {
			double resultado = 1;
			for(int i = 0; i< -numB; i++) {
				resultado /= numA;
			}
			return resultado;
		}
	}
	
}
