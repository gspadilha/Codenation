package br.com.codenation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StatisticUtil {

	public static void main(String[] args) {
		try {
			System.out.println(StatisticUtil.median(new int[] {-1,-2,-3,-4,-5,-5}));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int average(int[] elements) {
		int soma = 0;

		for (int item: elements) {
			soma += item;
		}

		return soma/elements.length;
	}

	public static int mode(int[] elements) {
		Arrays.sort(elements);

		Map<Integer, Integer> elementosPorQuantidade = new HashMap<Integer, Integer>();

		for (int item: elements) {
			System.out.println(item);
			if (!elementosPorQuantidade.containsKey(item)) {
				elementosPorQuantidade.put(item, 0);
			} else {
				elementosPorQuantidade.put(item, elementosPorQuantidade.get(item)+1);
			}
		}

		int maior = 0;
		int indice = 0;

		for (Map.Entry<Integer, Integer> entry : elementosPorQuantidade.entrySet()) {
			if (entry.getValue() > maior) {
				maior = entry.getValue();
				indice = entry.getKey();
			}
		}

		return indice;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);

		if (elements.length % 2 != 0) {
			int meioImpar = (int) Math.floor(elements.length/2.0);
			return elements[meioImpar];
		}

		if (elements.length % 2 == 0) {
			int meioPar = (int) Math.floor(elements.length/2.0);
			System.out.println(meioPar);
			return (elements[meioPar-1] + elements[(meioPar)])/2;
		}

		return 0;
	}
}