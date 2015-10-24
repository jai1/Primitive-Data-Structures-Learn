package org.bitsight;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

class Bin {

	@Override
	public String toString() {
		return "Bin [fromKey=" + fromKey + ", toKey=" + toKey + ", repeatitionOfFromKey=" + repeatitionOfFromKey
				+ ", actualSize=" + actualSize + "]";
	}

	Integer fromKey;
	Integer toKey;
	Integer repeatitionOfFromKey;
	Integer actualSize;

	Bin() {
		repeatitionOfFromKey = 0;
		fromKey = 0;
		actualSize = 0;
		toKey = 0;
	}

	public Integer getFromKey() {
		return fromKey;
	}

	public void setFromKey(Integer fromKey) {
		this.fromKey = fromKey;
	}

	public Integer getToKey() {
		return toKey;
	}

	public void setToKey(Integer toKey) {
		this.toKey = toKey;
	}

	public Integer getRepeatitionOfFromKey() {
		return repeatitionOfFromKey;
	}

	public void setRepeatitionOfFromKey(Integer repeatitionOfFromKey) {
		this.repeatitionOfFromKey = repeatitionOfFromKey;
	}

	public Integer getActualSize() {
		return actualSize;
	}

	public void setActualSize(Integer actualSize) {
		this.actualSize = actualSize;
	}

}

public class Partitioner {

	TreeMap<Integer, Integer> map;
	Integer numberOfBins;

	public Partitioner() {
		map = new TreeMap<Integer, Integer>();
	}

	public void run(String[] args) {
		if (args.length < 2) {
			System.out.println("Need Input File Name and Output File Name as arguments.");
		}
		pareInputFile(args[0]);
		System.out.println(map.toString());
		populateBins();
		// createOutput(args[1]);
		return;
	}

	private void populateBins() {
		Bin[] bins = new Bin[numberOfBins];
		Integer binNumber = 0;
		Integer idealbinSize = map.size() / numberOfBins;
		for (int i =0; i< numberOfBins; i++) {
			bins[i] = new Bin();
		}

		for (Integer key : map.keySet()) {
			Integer actualSize = bins[binNumber].getActualSize();
			if (actualSize >= idealbinSize) {
				binNumber++;
				actualSize = 0;
			}
			if (actualSize == 0)
				bins[binNumber].setFromKey(key);
			
			bins[binNumber].setActualSize(actualSize + map.get(key));
			bins[binNumber].setToKey(key);
			bins[binNumber].setRepeatitionOfFromKey(map.get(key));
			System.out.println("Index: " + binNumber);
			System.out.println(bins[binNumber]);
		}
		
		for(Bin b: bins) {
			System.out.println(b);
		}
		
	}

	

	private void pareInputFile(String string) {
		Scanner in = null;
		try {
			in = new Scanner(new File(string));
			if (in.hasNextInt())
				numberOfBins = in.nextInt();
			while (in.hasNextInt()) {
				Integer i = in.nextInt();
				if (map.containsKey(i))
					map.put(i, map.get(i) + 1);
				else
					map.put(i, 1);
			}
		} catch (Exception e) {
			System.out.println("Exception Occured: " + e.toString());
		} finally {
			if (in != null)
				in.close();
		}
	}
}