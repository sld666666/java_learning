package java_learning;

import java.io.File;

/**
 * Created by diwu.sld on 2017/1/16.
 */
public class CreateAppService {

    public Boolean createAppProject(AppConfig appConfig){
        String path = "e:\\app-aliplanet\\src\\main\\java\\com\\taobao\\app";
        File file = new File(path);
        if (!file.exists()){
            if (!file.mkdir()){
                System.out.print("error");
            }
        }

        return  true;
    }
}
