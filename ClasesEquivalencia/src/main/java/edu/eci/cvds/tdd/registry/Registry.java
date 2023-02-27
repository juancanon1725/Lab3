package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {
    private ArrayList<Person> registeredVoters;

    public Registry(){
            registeredVoters = new ArrayList<>();
    }

    public RegisterResult registerVoter(Person p) {
        // TODO Validate person and return real result.
            if (!p.isAlive()) {
                return RegisterResult.DEAD;
            }
            if (p.getAge() < 0) {
                return RegisterResult.INVALID_AGE;
            }
            if (p.getAge() < 18){
                return RegisterResult.UNDERAGE;
            }
            for (int i = 0; i<registeredVoters.size();i++){
                if (registeredVoters.get(i).getId() == p.getId()){
                    return RegisterResult.DUPLICATED;
                }
            }
            registeredVoters.add(p);
            return RegisterResult.VALID;
        }
    }
