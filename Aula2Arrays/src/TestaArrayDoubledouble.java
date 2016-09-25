public class TestaArrayDoubledouble {
	public static void main (String[]args){
double mediaS = 0;
long tInit = System. currentTimeMillis();
double [][] d = new double [1000][1000];
	for (int i = 0; i<d.length;i++){
		for (int j = 0;j<d[i].length;j++){
			d[i][j] = Math.random()*10;
		mediaS += d[i][j];
		}
	}
	
	System.out.println ("Média dos resultados: "+(String.format("%1.3f", (mediaS/(d.length*d[0].length)))));
	System.out.println ("Tempo levado: "+(System. currentTimeMillis()-tInit+ " ms"));
	}

}
