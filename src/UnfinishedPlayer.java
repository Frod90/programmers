import java.util.HashMap;
import java.util.Map;

public class UnfinishedPlayer {

	public String solution(String[] participant, String[] completion) {

		Map<String, Integer> player = new HashMap<>();

		for (String eachParticipant : participant) {
			player.put(eachParticipant, player.getOrDefault(eachParticipant, 0) + 1);
		}

		for (String eachCompletion : completion) {
			player.replace(eachCompletion, player.get(eachCompletion) - 1);
		}

		for (String eachParticipant : participant) {
			int count = player.get(eachParticipant);

			if (count != 0) {
				return eachParticipant;
			}
		}

		return "";
	}
}
