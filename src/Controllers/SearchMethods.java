package Controllers;

import Models.Person;

public class SearchMethods {
    
    public Person binarySearchByAge(Person[] persons, int age) {
        if (persons == null || persons.length == 0) {
            return null;
        }
        
        int left = 0;
        int right = persons.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (persons[mid].getAge() == age) {
                return persons[mid];
            }
            
            if (persons[mid].getAge() < age) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return null;
    }
    
    public Person binarySearchByName(Person[] persons, String name) {
        if (persons == null || persons.length == 0 || name == null) {
            return null;
        }
        
        int left = 0;
        int right = persons.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int compareResult = persons[mid].getName().compareToIgnoreCase(name);
            
            if (compareResult == 0) {
                return persons[mid];
            }
            
            if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return null;
    }
    
    public boolean isSortedByAge(Person[] persons) {
        if (persons == null || persons.length <= 1) {
            return true;
        }
        
        for (int i = 0; i < persons.length - 1; i++) {
            if (persons[i] != null && persons[i + 1] != null && 
                persons[i].getAge() > persons[i + 1].getAge()) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isSortedByName(Person[] persons) {
        if (persons == null || persons.length <= 1) {
            return true;
        }
        
        for (int i = 0; i < persons.length - 1; i++) {
            if (persons[i] != null && persons[i + 1] != null && 
                persons[i].getName().compareToIgnoreCase(persons[i + 1].getName()) > 0) {
                return false;
            }
        }
        
        return true;
    }
}