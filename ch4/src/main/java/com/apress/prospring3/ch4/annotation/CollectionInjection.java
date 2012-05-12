/**
 * Created on Sep 21, 2011
 */
package com.apress.prospring3.ch4.annotation;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author Clarence
 *
 */
@Service("injectCollection")
public class CollectionInjection {

	@Resource(name="map")
	private Map<String, Object> map;

	@Resource(name="props")
    private Properties props;

	@Resource(name="set")
    private Set set;

	@Resource(name="list")
    private List list;

    public static void main(String[] args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context-annotation.xml");
		ctx.refresh();  

        CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
        instance.displayInfo();
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void displayInfo() {

        // display the Map
        System.out.println("Map contents:\n");
        System.out.println("Map size: " + map.size());
        for (Map.Entry<String, Object> mapEntry: map.entrySet()) {
        	System.out.println("Key: " + mapEntry.getKey() + " - Value: " + mapEntry.getValue());
        }

        // display the properties
        System.out.println("\nProperties contents:\n");
        for (Map.Entry<Object, Object> entry: props.entrySet()) {
        	System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }

        // display the set
        System.out.println("\nSet contents:\n");
        for (Object obj: set) {
        	System.out.println("Value: " + obj);
        }

        // display the list
        System.out.println("\nList contents:\n");
        for (Object obj: list) {
        	System.out.println("Value: " + obj);
        }      
    }
}
