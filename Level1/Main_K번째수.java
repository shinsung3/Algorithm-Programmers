import java.util.Arrays;

public class Main_K번째수 {

	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		
		solution(array, commands);
	}
	
	static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        
		for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0]-1;
			int end = commands[i][1];
			int idx = commands[i][2];
			
			int ii=0;
			int[] temp = new int[end-start];
			for(int j=start; j<end; j++) {
				temp[ii] = array[j];
				ii++;
			}
			
			Arrays.sort(temp);
			
			answer[index] = temp[idx-1];
			index++;
        }
		
        return answer;
    }
}