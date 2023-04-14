package exercise.template;

public class GetTemplate {
    public String getStrJsonHello() {
        String getStrJsonHello;
        getStrJsonHello = "{\n" +
                "  \"values\": [\n" +
                "    {\n" +
                "      \"isHello\": true,\n" +
                "      \"message\": \"Hello World!\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        //getStrJsonHello = getStrJsonHello.replaceAll(" ", "");

        return getStrJsonHello;
    }
}
