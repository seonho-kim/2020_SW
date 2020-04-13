import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static final int MAX = 1000;
	static int[] d = new int[MAX + 1];
	static int[] p = new int[MAX + 1];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
			d[i] = 10000;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				d[i] = Math.min(d[i], d[i-j] + p[j]);
			}
		}
		bw.write(d[N] + "");
		bw.flush();
	}
}
// 카드 구매하기 2 - 04:04.50