package leveltwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class P92334 {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		Set<String> reports = Arrays.stream(report)
			.collect(Collectors.toSet());

		Map<String, Integer> reportResult = new HashMap<>();
		Map<String, List<String>> reportDetails = new HashMap<>();

		for (String eachReport : reports) {
			String[] split = eachReport.split(" ");
			String id = split[0];
			String reportedUser = split[1];

			reportResult.put(reportedUser, reportResult.getOrDefault(reportedUser, 0) + 1);

			List<String> list = reportDetails.getOrDefault(reportedUser, new ArrayList<>());
			list.add(id);
			reportDetails.put(reportedUser, list);
		}

		Map<String, Integer> answerDetail = new HashMap<>();

		for (String id : reportResult.keySet()) {
			if (reportResult.get(id) >= k) {

				List<String> list = reportDetails.get(id);

				for (String countID : list) {
					answerDetail.put(countID, answerDetail.getOrDefault(countID, 0) + 1);
				}

			}
		}

		for (int i = 0; i < id_list.length; i++) {

			answer[i] = answerDetail.getOrDefault(id_list[i], 0);
		}

		// System.out.println(reportResult);
		// System.out.println(reportDetails);

		return answer;
	}

}
