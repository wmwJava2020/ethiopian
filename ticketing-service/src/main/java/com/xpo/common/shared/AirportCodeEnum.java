package com.xpo.common.shared;

public enum AirportCodeEnum {

    ADD("Addis Ababa Bole International"),
    DFW("Dallas Fort Worth International"),
    JFK("John F. Kennedy International"),
    LAX("Los Angeles International"),
    ORD("O'Hare International"),
    ATL("Hartsfield-Jackson Atlanta International"),
    SEA("Seattle-Tacoma International"),
    IAD("Washington Dulles International"),
    LHR("London Heathrow"),
    DCA("Ronald Reagan Washington National");

    private final String airportName;

    AirportCodeEnum(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportName() { return airportName; }
    public String getCode()        { return this.name(); }
}
