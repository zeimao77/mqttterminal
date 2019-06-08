package top.zeimao77.consts;

@SuppressWarnings("unused")
public enum AligenieQuery {

    QUERY("Query","查询所有标准属性"),
    QUERYCOLOR("QueryColor","查询颜色"),
    QUERYPOWERSTATE("QueryPowerState","查询电源开关"),
    QUERYTEMPERATURE("QueryTemperature","查询温度"),
    QUERYHUMIDITY("QueryHumidity","查询湿度"),
    QUERYWINDSPEED("QueryWindSpeed","查询风速"),
    QUERYBRIGHTNESS("QueryBrightness","查询亮度"),
    QUERYFOG("QueryFog","查询雾量"),
    QueryMode("QueryMode","查询模式"),
    QueryPM25("QueryPM25","查询pm2.5 含量"),
    QueryDirection("QueryDirection","查询方向"),
    QueryAngle("QueryAngle","查询角度"),
    ;

    String query;
    String name;

    AligenieQuery(String query,String name){
        this.query = query;
        this.name = name;
    }

    public String getQuery() {
        return query;
    }

    public String getName(){
        return name;
    }
}
