import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static final int MAX = 100;
	static int[][] d = new int[MAX + 1][10];
	static final int MOD = 1000000000;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < 10; i++)
			d[1][i] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j > 0) d[i][j] += (d[i-1][j-1] % MOD);
				if (j < 9) d[i][j] += (d[i-1][j+1] % MOD);
			}		
		}
		
		long result = 0;
		for (int i = 0; i < 10; i++)
			result = ((result % MOD) + (d[N][i] % MOD)) % MOD;
		bw.write(result + "");	
		bw.flush();
	}
}
// 쉬운 계단 수 - 17:16.01