import java.util.Scanner;

public class Main_직사각형별찍기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); //새로
		int b = sc.nextInt(); //가로 
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<b; i++) {
			for(int j=0; j<a; j++) {
				sb.append("*");
			}
			if(i!=b-1)
				sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}