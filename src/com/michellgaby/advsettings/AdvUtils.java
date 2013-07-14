package com.michellgaby.advsettings;

import java.io.PrintWriter;

import android.app.ProgressDialog;
import android.util.Log;

public class AdvUtils {

    public static void runCmd(String cmd)
    {
    	try {
    		boolean root = true;
    		if (root) {
    			Process p = Runtime.getRuntime().exec("su");
    			PrintWriter pw = new PrintWriter(p.getOutputStream());
    			pw.println(cmd);
    			pw.flush();
    			pw.close();
    			p.waitFor();
    		} else {
	    		Process p = Runtime.getRuntime().exec(cmd);
	    		p.waitFor();
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public static void reboot(int mode) {
    	switch (mode) {
		case 0:
			runCmd("reboot -p");
			break;
		case 1:
			runCmd("busybox killall system_server");
			break;
		case 2:
			runCmd("reboot recovery");
			break;
    	}
    }
}
