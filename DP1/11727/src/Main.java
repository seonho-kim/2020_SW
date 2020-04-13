import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int n;
	static final int MAX = 1000;
	static final int MOD = 10007;
	static int[][] d = new int[4][MAX+1];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		d[0][0] = 0;
		d[1][0] = 0;
		d[2][0] = 0;
		d[3][0] = 1;
		for (int i = 1; i <= n; i++) {
			d[0][i] = (d[3][i-1] % MOD + d[3][i-1] % MOD) % MOD;
			d[1][i] = d[2][i-1] % MOD;
			d[2][i] = d[2][i-1] % MOD;
			d[3][i] = (d[3][i-1] % MOD + d[0][i-1] % MOD) % MOD;
		}
		bw.write(d[3][n] + "");
		bw.flush();
	}
}
// 2¡¿n Å¸ÀÏ¸µ 2 - 05:14.93