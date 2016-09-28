package tga;

import java.util.Comparator;
//implementa��o de Comparator para ser utilizado no sort do arrayList.
public class Comparador implements Comparator<IndexedWord> {

	@Override
	public int compare(IndexedWord o1, IndexedWord o2) {
		return o1.getPalavra().compareTo(o2.getPalavra());
	}

}
