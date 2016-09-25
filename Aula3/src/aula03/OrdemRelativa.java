package aula03;

public enum OrdemRelativa {
	ANTECESSOR, EQUIVALENTE, SUCESSOR;

	static OrdemRelativa ComparaItem(RandomItem a, RandomItem a2) {
		if (a.getName().compareTo(a2.getName()) == 0) {
			return OrdemRelativa.EQUIVALENTE;
		} else if (a.getName().compareTo(a2.getName()) > 0) {
			return OrdemRelativa.ANTECESSOR;
		} else {
			return OrdemRelativa.SUCESSOR;
		}
	}

}
