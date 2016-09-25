package aula03;

public class Ordena {

	public static void OrdenaSS(RandomItem[] a) {
		RandomItem tempA = null;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (OrdemRelativa.ComparaItem(a[i], a[j]) == OrdemRelativa.ANTECESSOR) {
					tempA = a[i];
					a[i] = a[j];
					a[j] = tempA;

				}
			}
		}
	}

	public static void OrdenaIS(RandomItem[] a) {
	    for (int i = 1; i < a.length; i++) { 
	        int j = i; 
	        RandomItem B = a[i]; 
	        while ((j > 0) && (OrdemRelativa.ComparaItem(a[j-1], B) == OrdemRelativa.ANTECESSOR)) { 
	            a[j] = a[j-1]; 
	            j--; 
	        }
	        a[j] = B;
	    }
	}

	
	public static void OrdenaBS (RandomItem[] a){
				int i = a.length-1;
				while (i > 0) {
					int lastFlipped = 0;
					for (int j = 0; j < i; j++) { 
						if (OrdemRelativa.ComparaItem(a[j], a[j+1]) == OrdemRelativa.ANTECESSOR) { 
							RandomItem T = a[j]; 
							a[j] = a[j+1]; 
							a[j+1] = T; 

							lastFlipped = j; 
						}
					}
					i = lastFlipped;
				}
			}

		
			
		}
