package com.Repository;

import java.util.ArrayList;
import java.util.List;

public class Dunya {

	public int gecenGun(int gunSon) {

		int gun = 1;
		gun++;
		System.out.println("Geçen gün : " + gun);
		if (gun >= gunSon) {
			System.out.println("Dünya'nın süresi doldu.");
			return 0;
		}
		return gun;
	}

	public List<Long> asilama(List<Long> doktor, List<Long> hasta, List<Long> saglikli, int gun) {

		List<Long> asili = new ArrayList<Long>();
		for (int i = 0; i < doktor.size(); i++) {
			if (doktor.get(i) * 10 <= hasta.get(i)) {
				asili.add(doktor.get(i) * 10);
				hasta.set(i, hasta.get(i) - (doktor.get(i) * 10));

			} else {
				if (doktor.get(i) * 10 <= (hasta.get(i) + saglikli.get(i))) {
					asili.add(doktor.get(i) * 10);
					hasta.set(i, (long) 0);
					saglikli.set(i, saglikli.get(i) - ((doktor.get(i) * 10) - hasta.get(i)));

				} else if (doktor.get(i) * 10 > (hasta.get(i) + saglikli.get(i))) {
					asili.add(hasta.get(i) + saglikli.get(i));
					hasta.set(i, (long) 0);
					saglikli.set(i, (long) 0);
				}
			}
			gun = gecenGun(gun);
		}
		return asili;
	}
}
