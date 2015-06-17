package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

public class OnlyExceptionHandlerOverride_03_01 {

	public void e_03_01(IllegalArgumentException ex) {
		// Does nothing.
	}

	public void e_03_01(FileNotFoundException ex) {
		// Does nothing.
	}
}
