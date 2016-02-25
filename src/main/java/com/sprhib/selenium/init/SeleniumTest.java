package com.sprhib.selenium.init;

import java.util.List;
import java.util.ArrayList;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.sprhib.selenium.test.*;

public class SeleniumTest 
{
	public static void main(String[] args) {
		int testCount = 0;
		int failureCount = 0;
		long runTime = 0;
		List<Class> testCases = new ArrayList<Class>();
		testCases.add(HomePageTest.class);
		testCases.add(OrganizationAddPageTest.class);
		testCases.add(TeamAddPageTest.class);
		testCases.add(MemberAddPageTest.class);
		testCases.add(MemberListPageTest.class);
		testCases.add(TeamListPageTest.class);
		testCases.add(OrganizationListPageTest.class);
		
		for (Class c: testCases) {
			Result r = JUnitCore.runClasses(c);
			for (Failure f: r.getFailures()) {
				System.out.printf("Failure found!\n");
				f.getException().printStackTrace(System.out);
				System.out.printf("\n\n\n");
			}
			failureCount += r.getFailureCount();
			testCount += r.getRunCount();
			runTime += r.getRunTime();
		}
		System.out.printf("%s\n Run: %d --- Failed: %d --- Total Run Time: %f s\n", 
			(failureCount == 0) ? "All Tests passed!" : "There were failures...",
			testCount, failureCount, runTime/1000.0);
	}
}
