package ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class ch1 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=0; tc<T; tc++) {
			String str = bf.readLine();
			Stack<Character> s = new Stack<Character>();
			boolean flag = true;
			
			for(int i=0; i<str.length(); i++) {
				// 현재 문자가 '(' 인 경우 스택에 저장
				if(str.charAt(i) == '(') 
					s.push('(');
				
				// 현재 문자가 ')' 인 경우
				else {
					// 스택이 비어있거나 스택에 저장된 값이 ')' 인 경우 - 올바른 괄호 문자 X
					if(s.isEmpty() || s.peek() == ')') {	
						flag = false;
						break;
					}
					
					else if(s.peek() == '(') // 스택에 저장된 값이 '(' 인 경우 -> 제거
						s.pop();
				}
			}
			
			if(!flag || !s.isEmpty())
				System.out.println("NO");
			else
				System.out.println("YES");
		}
		
		bf.close();
	}

}