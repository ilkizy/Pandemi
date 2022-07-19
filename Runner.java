package com.Runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Repository.Insan;

public class Runner {

	public static void main(String[] args) {

		Insan insan = new Insan();
		Insan superInsan = new Insan();
		Insan doktor = new Insan();
		Insan hasta = new Insan();
		Insan saglikli = new Insan();

		List<Long> InsanListe = new ArrayList<Long>();
		List<Long> SuperListe = new ArrayList<Long>();
		List<Long> DoktorListe = new ArrayList<Long>();
		List<Long> HastaListe = new ArrayList<Long>();
		List<Long> SaglikliListe = new ArrayList<Long>();
		List<Long> AsiliListe = new ArrayList<Long>();
		int gun = 1;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Dünya nüfusunu girin.");
		long nufus = scanner.nextLong();
		System.out.println("Dünyadaki ülke sayýsýný girin.");
		int ulkeSayisi = scanner.nextInt();
		System.out.println("Dünyada geçecek zamaný gün olarak girin.");
		int gunSon = scanner.nextInt();
		System.out.println("Süper insan yüzdesini girin.");
		float superOran = scanner.nextFloat();
		System.out.println("Doktor yüzdesini girin.");
		float doktorOran = scanner.nextFloat();
		System.out.println("Hasta yüzdesini girin.");
		float hastaOran = scanner.nextFloat();
		float saglikliOran = 100 - (superOran + doktorOran + hastaOran);

		SuperListe = superInsan.dagit(superInsan.olustur(nufus, superOran), ulkeSayisi);
		DoktorListe = doktor.dagit(doktor.olustur(nufus, doktorOran), ulkeSayisi);
		HastaListe = hasta.dagit(hasta.olustur(nufus, hastaOran), ulkeSayisi);
		SaglikliListe = saglikli.dagit(saglikli.olustur(nufus, saglikliOran), ulkeSayisi);
		InsanListe = insan.dagitNufus(SuperListe, DoktorListe, HastaListe, SaglikliListe, ulkeSayisi);

		while (gun <= gunSon) {

			AsiliListe = insan.asilama(DoktorListe, HastaListe, SaglikliListe, gun, gunSon);
			insan.getir(InsanListe, SuperListe, DoktorListe, HastaListe, SaglikliListe, AsiliListe, ulkeSayisi);
			insan.toplamGetir(InsanListe, SuperListe, DoktorListe, HastaListe, SaglikliListe, AsiliListe, ulkeSayisi);
			System.out.println("Geçen gün : " + gun);
			gun++;
		}
		System.out.println("Dünyanýn süresi doldu.");

	}

}
