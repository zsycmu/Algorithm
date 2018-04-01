package MicrosoftOA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Person {
	private String name;
	private String phoneNumber;
	
	public Person(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
}

public class Phonebook
{
    private Map<String, Person> nameLookUpMap;
    private Map<String, Person> phoneNumberLookUpMap;
    
    public Phonebook(List<Person> people)
    {
        this.nameLookUpMap = new ConcurrentHashMap<String, Person>();
        this.phoneNumberLookUpMap = new ConcurrentHashMap<String, Person>();
        
        for (Person person : people) {
        	this.nameLookUpMap.put(person.getName(), person);
        	this.phoneNumberLookUpMap.put(person.getPhoneNumber(), person);
        }
    }

    public Person LookupByName(String name)
    {
        if (name == null || name.length() == 0) {
        	return null;
        }
        
        if (this.nameLookUpMap.containsKey(name)) {
        	return this.nameLookUpMap.get(name);
        }
        
        return null;
    }

    public Person LookupByPhoneNumber(String phoneNumber)
    {
        if (phoneNumber == null || phoneNumber.length() == 0) {
        	return null;
        }

        
        if (this.phoneNumberLookUpMap.containsKey(phoneNumber)) {
        	return this.phoneNumberLookUpMap.get(phoneNumber);
        }
        
        return null;
    }

    public void DeltePerson(Person person)
    {
    	if (person == null) {
    		return;
    	}
    	
    	Person target = this.nameLookUpMap.get(person.getName());
    	
    	if (target != null) {
            this.nameLookUpMap.remove(person.getName());
    	}
    	
    	target = this.phoneNumberLookUpMap.get(person.getPhoneNumber());
    	
    	if (target != null) {
    		this.phoneNumberLookUpMap.remove(person.getPhoneNumber());
    	}
    }
    
    public static void main(String[] args) {
    	List<Person> input = new ArrayList<Person>();
    	
    	input.add(new Person("a", "1"));
    	input.add(new Person("b", "2"));
    	input.add(new Person("c", "3"));
    	
    	Phonebook test = new Phonebook(input);
    	
    	System.out.println(test.LookupByName("a").getName());
    	test.DeltePerson(new Person("a", "1"));

    	System.out.println(test.LookupByName("a").getName());
    	
    }
}

