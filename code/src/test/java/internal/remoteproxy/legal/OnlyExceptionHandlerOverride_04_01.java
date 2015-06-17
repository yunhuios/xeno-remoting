package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

public class OnlyExceptionHandlerOverride_04_01 {

	public static void e_04_01(IllegalArgumentException ex) {
		// Does nothing.
	}

	public static void e_04_01(FileNotFoundException ex) {
		// Does nothing.
	}
}
