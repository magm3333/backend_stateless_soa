package com.coop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.coop.business.IGraphBusiness;

@Configuration
@EnableScheduling
public class ScheduledEvents {
	@Autowired
	private SimpMessagingTemplate wsClient;

	// @Scheduled(fixedDelay = 1000)
	@Scheduled(fixedDelay = 1000, initialDelay = 100)
	// @Scheduled(cron = " 0 0/1 * 1/1 * ? *")
	public void demo() {
		wsClient.convertAndSend("/backend/numeros",Math.random()*1000);

	}
	
	
	@Autowired
	private IGraphBusiness graphService;
	
	@Scheduled(fixedDelay = 5000, initialDelay = 10000)
	// @Scheduled(cron = " 0 0/1 * 1/1 * ? *")
	public void estados() {
		graphService.pushGraphData();
		
	}
}
