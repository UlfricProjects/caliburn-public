package com.ulfric.caliburn;

import com.ulfric.caliburn.lives.UseLifeRequest;
import com.ulfric.caliburn.lives.UseLifeResponse;
import com.ulfric.caliburn.servers.Address;
import com.ulfric.caliburn.servers.Server;
import com.ulfric.caliburn.servers.ServersRequest;
import com.ulfric.caliburn.servers.ServersResponse;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Demo {

	private static final CaliburnClient CLIENT = CaliburnClient.defaultsWithSecret("YOUR SECRET");

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Run with a demo: hcf-direct-connect, use-lives");
			return;
		}

		List<String> arguments = Arrays.asList(args);
		if (arguments.contains("hcf-direct-connect")) {
			preDemo("HCF DIRECT CONNECT");
			demoHcfDirectConnectIps();
		}

		if (arguments.contains("use-lives")) {
			preDemo("USE LIVES");
			demoUseLives();
		}
	}

	private static void preDemo(String name) {
		System.out.println();
		System.out.println("DEMOING: " + name);
		System.out.println();
	}

	public static void demoHcfDirectConnectIps() {
		ServersRequest request = new ServersRequest();
		request.setGame("hcf"); // leave null to get all servers
		ServersResponse response = CLIENT.send(request, ServersResponse.class);

		if (printErrors(response)) {
			return;
		}

		for (Server server : response.getServers().get("hcf")) {
			Address directAddress = server.getDirectConnect();
			if (directAddress == null) {
				System.out.println("Cannot bypass hubs to join " + server.getName());
			} else {
				System.out.println("Bypass the hub and join " + server.getName() + " with " + directAddress.getIpAddress());
			}
		}
	}

	public static void demoUseLives() {
		UseLifeRequest request = new UseLifeRequest();
		request.setPlayer(UUID.randomUUID()); // leave null to use on yourself
		request.setServer("hcf");

		UseLifeResponse response = CLIENT.send(request, UseLifeResponse.class);

		if (printErrors(response)) {
			return;
		}

		System.out.println("Used a life on " + request.getPlayer());
	}

	private static boolean printErrors(Response response) {
		if (response.getErrors() != null) {
			for (Error error : response.getErrors()) {
				System.out.println(error.getCode() + ": " + error.getMessage());
			}

			return true;
		}

		return false;
	}

}
