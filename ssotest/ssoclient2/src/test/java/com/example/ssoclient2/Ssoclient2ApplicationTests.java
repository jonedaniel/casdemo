package com.example.ssoclient2;

import com.example.ssoclient2.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.krb5.internal.Ticket;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Ssoclient2ApplicationTests {

	@Autowired
	private RedisUtil redisUtil;

	@Test
	public void contextLoads() {
		redisUtil.set("ticket1", "ticket first");
		System.out.println(redisUtil.get("ticket1"));
	}

}
