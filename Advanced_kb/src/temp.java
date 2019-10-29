import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class temp {
    public static boolean createZipFile(String sourceFilePath, String targetPath, String zipFileName) {

        boolean flag = false;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        // 要压缩的文件资源
        File sourceFile = new File(sourceFilePath);
        // zip文件存放路径
        String zipPath = "";

        if (null != targetPath && !"".equals(targetPath)) {
            zipPath = targetPath + File.separator + zipFileName;
        } else {
            zipPath = new File(sourceFilePath).getParent() + File.separator + zipFileName;
        }

        if (sourceFile.exists() == false) {
            System.out.println("待压缩的文件目录：" + sourceFilePath + "不存在.");
            return flag;
        }

        try {
            File zipFile = new File(zipPath);
            if (zipFile.exists()) {
                System.out.println(zipPath + "目录下存在名字为:" + zipFileName + ".zip" + "打包文件.");
            } else {
                File[] sourceFiles = sourceFile.listFiles();
                if (null == sourceFiles || sourceFiles.length < 1) {
                    System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                } else {
                    fos = new FileOutputStream(zipPath);
                    zos = new ZipOutputStream(new BufferedOutputStream(fos));
                    // 生成压缩文件
                    writeZip(sourceFile, "", zos);
                    flag = true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (null != zos) {
                    zos.close();
                }
                if (null != fos) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    private static void writeZip(File file, String parentPath, ZipOutputStream zos) {
        if (file.exists()) {
            // 处理文件夹
            if (file.isDirectory()) {
                parentPath += file.getName() + File.separator;
                File[] files = file.listFiles();
                if (files.length != 0) {
                    for (File f : files) {
                        // 递归调用
                        writeZip(f, parentPath, zos);
                    }
                } else {
                    // 空目录则创建当前目录的ZipEntry
                    try {
                        zos.putNextEntry(new ZipEntry(parentPath));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                    ZipEntry ze = new ZipEntry(parentPath + file.getName());
                    zos.putNextEntry(ze);
                    byte[] content = new byte[1024];
                    int len;
                    while ((len = fis.read(content)) != -1) {
                        zos.write(content, 0, len);
                        zos.flush();
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("创建ZIP文件失败" + e);
                } catch (IOException e) {
                    System.out.println("创建ZIP文件失败" + e);
                } finally {
                    try {
                        if (fis != null) {
                            fis.close();
                        }
                    } catch (IOException e) {
                        System.out.println("创建ZIP文件失败" + e);
                    }
                }
            }
        }
    }


}
