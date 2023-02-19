package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.vfs.VirtualFile;
import org.apache.commons.lang.SystemUtils;

import java.io.IOException;

public class OpenInTyporaAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (file == null || !file.exists()) {
            System.out.println("文件不存在");
            return;
        }

        if (SystemUtils.IS_OS_WINDOWS) {
            String typoraPath = "c:\\Program Files\\Typora\\Typora.exe";
            // 如果配置了环境变量，可以直接使用 typora
            // String typoraPath = "typora";
            try {
                System.out.println(file.getPath());
                Runtime.getRuntime().exec(new String[]{typoraPath, file.getPath()});
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (SystemUtils.IS_OS_MAC) {
            try {
                Runtime.getRuntime().exec(new String[]{"open", "-a", "Typora", file.getPath()});
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
