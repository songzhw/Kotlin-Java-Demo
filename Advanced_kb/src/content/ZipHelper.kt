package content

import java.io.*
import java.util.zip.*


object ZipHelper {

    private val BUFFER_SIZE = 2 * 1024


    /**
     *
     * 压缩成ZIP 方法1
     *
     * @param srcDir 压缩文件夹路径
     *
     * @param out    压缩文件输出流
     *
     * @param KeepDirStructure  是否保留原来的目录结构,true:保留目录结构;
     *
     * false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     *
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */


    @Throws(RuntimeException::class)
    fun toZip(srcDir: String, outFile: String) {


        val start = System.currentTimeMillis()
        var zos: ZipOutputStream? = null
        val out = FileOutputStream(File(outFile))

        try {

            zos = ZipOutputStream(out)

            val sourceFile = File(srcDir)

            compress(sourceFile, zos, sourceFile.name)

            val end = System.currentTimeMillis()

            println("压缩完成，耗时：" + (end - start) + " ms")

        } catch (e: Exception) {

            throw RuntimeException("zip error from ZipUtils", e)

        } finally {

            if (zos != null) {

                try {

                    zos.close()

                } catch (e: IOException) {

                    e.printStackTrace()

                }

            }

        }


    }


    /**
     *
     * 递归压缩方法
     *
     * @param sourceFile 源文件
     *
     * @param zos        zip输出流
     *
     * @param name       压缩后的名称
     *
     * @param KeepDirStructure  是否保留原来的目录结构,true:保留目录结构;
     *
     * false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     *
     * @throws Exception
     */

    @Throws(Exception::class)
    private fun compress(
        sourceFile: File, zos: ZipOutputStream, name: String
        ) {

        val buf = ByteArray(BUFFER_SIZE)

        if (sourceFile.isFile) {

            // 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字

            zos.putNextEntry(ZipEntry(name))

            // copy文件到zip输出流中


            val `in` = FileInputStream(sourceFile)
            var len: Int = `in`.read(buf)

            while (len != -1) {

                zos.write(buf, 0, len)
                len = `in`.read(buf)
            }

            // Complete the entry

            zos.closeEntry()

            `in`.close()

        } else {

            val listFiles = sourceFile.listFiles()

            if (listFiles == null || listFiles.size == 0) {

                // 需要保留原来的文件结构时,需要对空文件夹进行处理


                // 空文件夹的处理

                zos.putNextEntry(ZipEntry("$name/"))

                // 没有文件，不需要文件的copy

                zos.closeEntry()


            } else {

                for (file in listFiles) {

                    // 判断是否需要保留原来的文件结构


                    // 注意：file.getName()前面需要带上父文件夹的名字加一斜杠,

                    // 不然最后压缩包中就不能保留原来的文件结构,即：所有文件都跑到压缩包根目录下了

                    compress(file, zos, name + "/" + file.name)


                }

            }

        }

    }
}


fun main() {
    val fromFolder = "/Users/zsong/temp/epub_reader/html_unzipped"
    val toFile = "/Users/zsong/temp/epub_reader/t9.zip"

    ZipHelper.toZip(fromFolder, toFile)
}