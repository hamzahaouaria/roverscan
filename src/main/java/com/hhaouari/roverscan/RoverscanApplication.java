package com.hhaouari.roverscan;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.services.MissionControlService;
import com.hhaouari.roverscan.services.impl.MissionControlServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoverscanApplication {

	public static void main(String[] args) {
		// java -jar rover.jar input.txt
		String fileInput = args[0];
		MissionControlService missionControlService = new MissionControlServiceImpl();
		Mission mission = missionControlService.execute(fileInput);
		System.out.println(mission);
		//SpringApplication.run(RoverscanApplication.class, args);
	}

}
