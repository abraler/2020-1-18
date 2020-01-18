package HTTP;

import java.util.HashMap;
import java.util.Map;

public class Request {
    String method;//请求方法 get  delete   put
    String path;//路径
    String version;//版本

    Map<String,String >apraments=new HashMap<>();
    Map<String ,String >headers=new HashMap<>();

}
