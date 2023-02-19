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

        String typoraPath = null;
        if (SystemUtils.IS_OS_WINDOWS) {
            typoraPath = System.getenv("ProgramFiles") + "\\Typora\\Typora.exe";
        } else if (SystemUtils.IS_OS_MAC) {
            typoraPath = "Typora";
        }

        if (typoraPath != null) {
            try {
                Runtime.getRuntime().exec(new String[]{"open", "-a", typoraPath, file.getPath()});
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            // 处理无法找到 Typora 安装路径的情况
            System.out.println("找不到typora");
        }
    }
}
