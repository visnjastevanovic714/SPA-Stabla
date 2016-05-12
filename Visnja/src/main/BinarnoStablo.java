package main;

import labis.cvorovi.CvorStabla;
import labis.exception.LabisException;
import labis.stabla.ABinarnoStablo;

public class BinarnoStablo extends ABinarnoStablo {

	@Override
	public boolean daLiPostojiIsti(CvorStabla k, CvorStabla neki) throws LabisException {
		if (k == null || neki == null)
			return false;
		if (k.podatak == neki.podatak && k != neki)
			return true;
		return daLiPostojiIsti(k.levo, neki) || daLiPostojiIsti(k.desno, neki);
	}

	@Override
	public CvorStabla vratiMaksimalanPolulist(CvorStabla k) throws LabisException {
		if (k == null)
			return null;
		CvorStabla maxPoluList = null;
		CvorStabla maxLeviPoluList = vratiMaksimalanPolulist(k.levo);
		CvorStabla maxDesniPoluList = vratiMaksimalanPolulist(k.desno);
		if ((k.levo == null && k.desno != null) || (k.desno == null && k.levo != null))
			maxPoluList = k;
		if (maxPoluList == null || (maxLeviPoluList != null && maxLeviPoluList.podatak > maxPoluList.podatak))
			maxPoluList = maxLeviPoluList;
		if (maxPoluList == null || (maxDesniPoluList != null && maxDesniPoluList.podatak > maxPoluList.podatak))
			maxPoluList = maxDesniPoluList;
		return maxPoluList;
	}
}
