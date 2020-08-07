package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String file = sc.nextLine();
		
		Map<String, Integer> votes = new LinkedHashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			while (line != null) {
				String[] info = line.split(",");
				if (votes.containsKey(info[0])) {
					int sum = votes.get(info[0]) + Integer.parseInt(info[1]);
					votes.put(info[0], sum);
				} else {
					votes.put(info[0], Integer.parseInt(info[1]));
				}
				line = br.readLine();				
			}
			
			for (String key : votes.keySet()) {
			System.out.println(key + ": " + votes.get(key));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}
