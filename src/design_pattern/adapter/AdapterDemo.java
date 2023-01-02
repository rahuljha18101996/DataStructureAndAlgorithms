package design_pattern.adapter;

/*
* Adapter Design Pattern
* Structural Design Pattern : Improve the structure of code
* When Object offers same features, but has different interface. i.e., Charging Adapter, USB to Ethernet Adapter
* It allows existing classes to be used without modifying their source code
* i.e.,WebDriver Adapter
*
* Interface: WebDriver
* Interface Implementation: ChromeDriver, WebDriverAdapter
* Adapter: WebDriveAdapter
* Adaptee: ie Driver
* Client: AdapterPatternTest
*
* */

interface WebDriver {
    void getElement();
    void setElement();
}

class ChromeDriver implements WebDriver {

    @Override
    public void getElement() {
        System.out.println("Get Element From ChromeDriver");
    }

    @Override
    public void setElement() {
        System.out.println("Set Element From ChromeDriver");
    }
}

class IEDriver {
    public void findElement(){
        System.out.println("Find Element From IEDriver");
    }
    public void clickElement() {
        System.out.println("Click Element From IEDriver");
    }
}

class WebDriverAdapter implements WebDriver {
    IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() {
        ieDriver.findElement();
    }

    @Override
    public void setElement() {
        ieDriver.clickElement();
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        ChromeDriver a = new ChromeDriver();
        a.getElement();
        a.setElement();

        IEDriver e = new IEDriver();
        e.findElement();
        e.clickElement();

        WebDriver wid = new WebDriverAdapter(e);
        wid.getElement();
        wid.setElement();
    }
}
