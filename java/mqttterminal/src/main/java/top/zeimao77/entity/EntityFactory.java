package top.zeimao77.entity;

import top.zeimao77.consts.Gpio;
import top.zeimao77.terminal.service.Terminal;

import java.util.HashMap;

public class EntityFactory {

    private static HashMap<String, Terminal> entityMap = new HashMap<>();

    private EntityFactory(){

    }

    public static void init(){
        Oled oled = new Oled("OLED_B5E07E6738B94EF998A816A12729FBC1");
        addTerminal(oled);
        Light light1 = new Light("LIGHT_D7A1656513CE41278A8043EC6E70AECF");
        light1.setGpio(Gpio.GPIO_24);
        light1.init();
        addTerminal(light1);
        Switch switch1 = new Switch("SWITCH_C6FAC7EC1382462FB4B689AC6F6821AE");
        switch1.setGpio(Gpio.GPIO_25);
        switch1.init();
        addTerminal(switch1);
    }

    public static boolean addTerminal(Terminal terminal) {
        for(String terminalId : entityMap.keySet()) {
            if(terminalId.equals(terminal.getTerminalId())) {
                return false;
            }
        }
        entityMap.put(terminal.getTerminalId(),terminal);
        return true;
    }

    public static Terminal getTerminal(String terminalId) {
        return entityMap.get(terminalId);
    }

}
