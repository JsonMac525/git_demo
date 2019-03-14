package com.jsp.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTest {
	@Async
	public void Test(){
		System.out.println("#########3");
		System.out.println("#########4");
	}
}
