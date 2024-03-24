public class HandlingString {

	public boolean solution(String s) {

		if(s.length() != 4 && s.length() != 6) {
			return false;
		}

		String pattern = "^[0-9]*$";
		return s.matches(pattern);
	}

}
