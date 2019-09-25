package loja;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class TesteData {
	public static void main(String[] args) {
		Date data = new Date(); // hora do relogio do computador
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(data);
	    System.out.println(sdf);
		System.out.println(sdf.format(data));
		System.out.println(data.getTime());

		Scanner scn = new Scanner(System.in);
		System.out.println("Data Nasc? ");
		String sdata = scn.next();
		try {
			data = sdf.parse(sdata);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(data);
	}
}
