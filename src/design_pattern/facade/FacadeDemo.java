package design_pattern.facade;

/*
* Facade Design Pattern
* Structural Design Pattern : Improve the structure of code
* Used when there are multiple interfaces of similar kind of Jobs, then we add a Facade interfaces, which provide better interfaces to these interfaces & client. It basically helps in routing to related interface.
* i.e., Drivers, Databases
*
* We will implement a Facade helper class, which will route to method related to specific class based on Input.
*
* */

import java.sql.Driver;

class Firefox {
    public static Driver getFirefoxDriver() {
        return null;
    }
    public static void generateHTMLReport(String test,Driver driver) {
        System.out.println("Generating HTML Report for Firefox Driver.");
    }
    public static void generateJUnitReport(String test,Driver driver) {
        System.out.println("Generating JUnit Report for Firefox Driver.");
    }
}

class Chrome {
    public static Driver getChromeDriver() {
        return null;
    }
    public static void generateHTMLReport(String test,Driver driver) {
        System.out.println("Generating HTML Report for Chrome Driver.");
    }
    public static void generateJUnitReport(String test,Driver driver) {
        System.out.println("Generating JUnit Report for Chrome Driver.");
    }
}

class WebExplorerHelperFacade {
    public static void generateReport(String explorer,String report, String test) {
        Driver driver = null;
        if (explorer.equals("Chrome")) {
            if (report.equals("HTML")) {
                Chrome.generateHTMLReport(test,driver);
            }else if (report.equals("JUnit")) {
                Chrome.generateJUnitReport(test,driver);
            }
        }else if (explorer.equals("Firefox")) {
            if (report.equals("HTML")) {
                Firefox.generateHTMLReport(test,driver);
            }else if (report.equals("JUnit")) {
                Firefox.generateJUnitReport(test,driver);
            }
        }else {
            System.out.println("Invalid Argument Passed");
        }
    }
}

public class FacadeDemo {
    public static void main(String[] args) {
        String test = "Test";
        WebExplorerHelperFacade.generateReport("Chrome","HTML",test);
        WebExplorerHelperFacade.generateReport("Chrome","JUnit",test);
        WebExplorerHelperFacade.generateReport("Firefox","HTML",test);
        WebExplorerHelperFacade.generateReport("Firefox","JUnit",test);
    }
}
