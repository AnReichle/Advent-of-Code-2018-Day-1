import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;

public class Main {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> input = new ArrayList<Integer>();
		String path = "C:\\Users\\Andreas\\Desktop\\Advent of Code\\2018 Day 1\\src\\input.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line;
			while((line = br.readLine()) != null)
			input.add(Integer.parseInt(line));
		}
		Optional<Integer> result = input.stream().reduce((x, y) -> x+y);
		System.out.println("answer for part (a): " + result.get());
		Integer partialSum = 0;
		outerLoop:
			for(HashSet<Integer> seen = new HashSet<Integer>();true;) {
				for(Iterator<Integer> i = input.iterator(); i.hasNext(); seen.add(partialSum)) {
					if(seen.contains(partialSum += i.next())) break outerLoop;
				}
			}
		System.out.println("answer for part (b): " + partialSum);
	}
}
