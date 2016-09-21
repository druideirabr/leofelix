
public class RecursaoTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fatorialr(5));
		System.out.println(MDC(50, 8));
		System.out.println(vChar("TA PEGANDO FOGO BICHO", 'x'));
		System.out.println(ackermann (4,1));
	}

	public static int multr(int m, int n) {
		if (n == 0)
			return 0;
		else
			return (m + multr(m, n - 1));
	}

	public static int fatorialr(int n) {
		if (n <= 1)
			return 1;
		else
			return multr(n, fatorialr(n - 1));
	}

	public static int MDC(int x, int y) {
		if (x >= y && x % y == 0) {
			return y;
		} else if (x < y) {
			return MDC(y, x);

		} else
			return MDC(y, x % y);

	}

	public static boolean vChar(String a, char b) {
		if (a.charAt(a.length() - 1) == b) {
			return true;
		} else if (a.charAt(a.length() - 1) != b && a.length() - 1 > 0)
			return vChar(a.substring(0, a.length() - 1), b);
		return false;
	}

	public static int ackermann(int m, int n) {
	    if (m < 0 || n < 0) {
	        throw new IllegalArgumentException("Non-negative args only!");
	    }

	    if (m == 0) {
	        return n + 1;
	    } else if (n == 0) {
	        return ackermann(m-1, 1); 
	    } else {
	        // perforce (m > 0) && (n > 0)
	        return ackermann(m-1, ackermann(m,n-1));
	    }
	}
}
