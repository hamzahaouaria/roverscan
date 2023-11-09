package com.hhaouari.roverscan;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.services.MissionControlService;
import com.hhaouari.roverscan.services.impl.MissionControlServiceImpl;
import com.hhaouari.roverscan.utils.TerminalOutputUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoverScanApplication {

	public static void main(String[] args) {
		TerminalOutputUtil terminalOutputUtil = new TerminalOutputUtil();
		String output = terminalOutputUtil.finalTerminalOutput(args);
		System.out.println(output);
		// TODO: (Enable) Spring context is not needed for now, Enable it when using
		// autowired beans
		// SpringApplication.run(RoverscanApplication.class, args);
	}

}
