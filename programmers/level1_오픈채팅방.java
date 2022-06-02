package algo;

import java.util.*;

public class level1_오픈채팅방 {

	public String[] solution(String[] record) {

		Map<String, String> nicknameMap = new HashMap<>();
		List<String> chat = new LinkedList<>();

		for (String info : record) {
			StringTokenizer st = new StringTokenizer(info);
			String condition = st.nextToken();
			String uid = st.nextToken();
			String nickname = "";

			if (st.hasMoreTokens()) {
				nickname = st.nextToken();
			}

			if (condition.equals("Enter")) {
				nicknameMap.put(uid, nickname);
				chat.add(uid + "님이 들어왔습니다.");
			} else if (condition.equals("Change")) {
				nicknameMap.put(uid, nickname);
			} else {
				chat.add(uid + "님이 나갔습니다.");
			}
		}

		String[] answer = new String[chat.size()];
		int idx = 0;

		for (String c : chat) {
			int uidEndIdx = c.indexOf("님");
			String uidTemp = c.substring(0, uidEndIdx);

			String lastUid = nicknameMap.get(uidTemp);
			if (lastUid != null) {

				answer[idx++] = c.replace(uidTemp, lastUid);
			} else {
				answer[idx++] = c;
			}

		}

		return answer;
	}

}
