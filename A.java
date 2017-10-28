import java.net.*;
import java.util.*;

public class exp71 {
	public static void main (String[] args) {
		try {
			InetAddress[] address = InetAddress.getAllByName("www.google.com");
			for (int i = 0; i <address.length; i++)  {
				System.out.println(address[i]);
			}
			InetAddress thisHost= InetAddress.getLocalHost();
			System.out.println("\n Address:"+thisHost);
			String localhost = thisHost.getHostName();
			String localip = thisHost.getHostAddress();
			System.out.println("\n Host:"+localhost);
			System.out.println("\n Address:"+localip);
		}
		catch (UnknownHostException e) {
			System.out.println("\nCould not find address");
		}
	}
}

/*
OUTPUT:
c502@comp:~$ gedit exp71.java
^C
c502@comp:~$ javac exp71.java
c502@comp:~$ java exp71
www.google.com/216.58.203.164
www.google.com/2404:6800:4009:807:0:0:0:2004

 Address:comp/127.0.1.1

 Host:comp

 Address:127.0.1.1
*/