import java.net.*;

public class AddressTests
{
	public static int getVersion(InetAddress ia)  {
		byte[] address = ia.getAddress( );
		if (address.length == 4) return 4;
		else if (address.length == 16) return 6;
		else return -1;
	}
	public static char getClass(InetAddress ia) {
		byte[] address = ia.getAddress( );
		if (address.length != 4) {
			throw new IllegalArgumentException("No IPv6 addresses!");
		}
		int firstByte = address[0];
		if ((firstByte& 0x80) == 0) return 'A';
		else if ((firstByte& 0xC0) == 0x80) return 'B';
		else if ((firstByte& 0xE0) == 0xC0) return 'C';
		else if ((firstByte& 0xF0) == 0xE0) return 'D';
		else if ((firstByte& 0xF8) == 0xF0) return 'E';
		else return 'F';
	}

	public static void main(String [] args) {
		try {
			InetAddress ia=InetAddress.getByName("127.0.0.1");
			AddressTests add=new AddressTests();
			System.out.println("\n IP version:"+getVersion(ia));
			System.out.println("\n Class:"+getClass(ia));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

/*
OUTPUT:
c502@comp:~$ javac AddressTests.java
c502@comp:~$ java AddressTests

 IP version:4

 Class:A
*/