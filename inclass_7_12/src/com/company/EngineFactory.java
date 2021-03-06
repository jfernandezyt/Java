package com.company;

public class  EngineFactory {

    public IEngine createEngine(EngineTypes type, int fuel){
        switch(type){
            case ELECTRIC:
                return new ElectricEngine();
            case BOAT:
                return new BoatEngine(fuel);
            case AIRPLANE:
                return new AirplaneEngine(fuel);
            case COMBUSTION:
                return new CombustionEngine(fuel);
            default:
                System.out.println("Not a valid engine");
        }
        return null;
    }
}
