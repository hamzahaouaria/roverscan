package com.hhaouari.roverscan;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.services.MissionControlService;
import com.hhaouari.roverscan.services.impl.MissionControlServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoverScanApplication {

	public static void main(String[] args) {
		String fileInput = args[0];
		MissionControlService missionControlService = new MissionControlServiceImpl();
		Mission mission = missionControlService.execute(fileInput);
		System.out.println(mission);
		// TODO: (Enable) Spring context is not needed for now, Enable it when using autowired beans
		// SpringApplication.run(RoverscanApplication.class, args);
	}

}
