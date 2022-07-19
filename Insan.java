package com.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Insan {

	public long olustur(long nufus, float oran) {

		Scanner scanner = new Scanner(System.in);
		long kisiSayisi = (long) (nufus * oran) / 100;

		return kisiSayisi;
	}

	public List<Long> dagit(long kisiSayisi, int ulke) {

		Random random = new Random();
		System.out.println();

		long kalan = kisiSayisi;
		int index = 0;
		List<Long> liste = new ArrayList<Long>();
		while (ulke != 0) {
			index = random.nextInt((int) kalan);
			if (kalan == 1) {
				liste.add(kalan);
				for (int i = ulke - 1; i > 0; i--) {
					liste.add((long) 0);
				}
				ulke = 1;
			} else {
				liste.add((long) index);
			}
			kalan = (kalan - index);
			ulke--;
		}
		return liste;
	}

	public List<Long> dagitNufus(List<Long> super1, List<Long> doktor, List<Long> hasta, List<Long> saglikli, int ulke) {
		List<Long> liste = new ArrayList<Long>();
		for (int i = 0; i < ulke; i++) {
			liste.add(super1.get(i) + doktor.get(i) + hasta.get(i) + saglikli.get(i));
		}
		return liste;
	}

	public void getir(List<Long> insan, List<Long> super1, List<Long> doktor, List<Long> hasta, List<Long> saglikli, List<Long> asili, int ulke) {
		for (int i = 0; i < ulke; i++) {

			System.out.println((i + 1) + ". Ülke - Nüfus: " + insan.get(i));
			System.out.println((i + 1) + ". Ülke - Süper insan: " + super1.get(i));
			System.out.println((i + 1) + ". Ülke - Doktor: " + doktor.get(i));
			System.out.println((i + 1) + ". Ülke - Hasta: " + hasta.get(i));
			System.out.println((i + 1) + ". Ülke - Saðlýklý: " + saglikli.get(i));
			System.out.println((i + 1) + ". Ülke - Aþýlý: " + asili.get(i));
			System.out.println();

		}
	}

	public void toplamGetir(List<Long> insan, List<Long> super1, List<Long> doktor, List<Long> hasta, List<Long> saglikli, List<Long> asili,
			int ulke) {

		long insanSayi = 0;
		long superSayi = 0;
		long doktorSayi = 0;
		long hastaSayi = 0;
		long saglikliSayi = 0;
		long asiliSayi = 0;

		for (int i = 0; i < ulke; i++) {
			insanSayi += insan.get(i);
			superSayi += super1.get(i);
			doktorSayi += doktor.get(i);
			hastaSayi += hasta.get(i);
			saglikliSayi += saglikli.get(i);
			asiliSayi += asili.get(i);
		}
		System.out.println("Toplam insan: " + insanSayi);
		System.out.println("Toplam süper: " + superSayi);
		System.out.println("Toplam doktor: " + doktorSayi);
		System.out.println("Toplam hasta: " + hastaSayi);
		System.out.println("Toplam saðlýklý: " + saglikliSayi);
		System.out.println("Toplam Aþýlý: " + asiliSayi);
	}

	public int gecenGun(int gun, int gunSon) {

		gun++;
		System.out.println("Geçen gün : " + gun);
		if (gun >= gunSon) {
			System.out.println("Dünya'nýn süresi doldu.");
			return 0;
		}
		return gun;
	}

	public List<Long> asilama(List<Long> doktor, List<Long> hasta, List<Long> saglikli, int gun, int gunSon) {

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
		}
		return asili;
	}
}
