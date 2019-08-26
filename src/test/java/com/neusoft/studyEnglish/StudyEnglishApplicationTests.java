package com.neusoft.studyEnglish;

import com.neusoft.studyEnglish.tool.baidufanyi.TransApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyEnglishApplicationTests {
	private static final String APP_ID = "20190825000329351";
	private static final String SECURITY_KEY = "HjhMSThpkywr05wnWaKN";
	@Test
	public void contextLoads() {
	}
	@Test
	public void fanyiTest() throws Exception{
		TransApi api = new TransApi(APP_ID, SECURITY_KEY);

		String query = "高度600米";
		System.out.println(api.getTransResult(query, "auto", "en"));
	}
}
