package Controllers;

import Models.Person;

public class ShortingMethods {
    
    public void sortByNameWithBubble(Person[] persons) {
        if (persons == null || persons.length <= 1) {
            return;
        }
        
        int n = persons.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (persons[j] != null && persons[j + 1] != null && 
                    persons[j].getName().compareToIgnoreCase(persons[j + 1].getName()) > 0) {
                    Person temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
    }
    
    public void sortByNameWithSelectionDes(Person[] persons) {
        if (persons == null || persons.length <= 1) {
            return;
        }
        
        int n = persons.length;
        
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (persons[j] != null && persons[maxIndex] != null && 
                    persons[j].getName().compareToIgnoreCase(persons[maxIndex].getName()) > 0) {
                    maxIndex = j;
                }
            }
            
            Person temp = persons[maxIndex];
            persons[maxIndex] = persons[i];
            persons[i] = temp;
        }
    }
    
    public void sortByAgeWithInsertion(Person[] persons) {
        if (persons == null || persons.length <= 1) {
            return;
        }
        
        int n = persons.length;
        
        for (int i = 1; i < n; i++) {
            Person key = persons[i];
            int j = i - 1;
            
            while (j >= 0 && persons[j] != null && key != null && persons[j].getAge() > key.getAge()) {
                persons[j + 1] = persons[j];
                j = j - 1;
            }
            
            persons[j + 1] = key;
        }
    }
    
    public void sortByNameWithInsertion(Person[] persons) {
        if (persons == null || persons.length <= 1) {
            return;
        }
        
        int n = persons.length;
        
        for (int i = 1; i < n; i++) {
            Person key = persons[i];
            int j = i - 1;
            
            while (j >= 0 && persons[j] != null && key != null && 
                  persons[j].getName().compareToIgnoreCase(key.getName()) > 0) {
                persons[j + 1] = persons[j];
                j = j - 1;
            }
            
            persons[j + 1] = key;
        }
    }
}