package xyz.scootaloo.thinking.rethinking.httpserver;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.GZIPOutputStream;

/**
 * @author AppleSack
 * @since 2023/04/21
 */
public class Utils {

    private static final String     defaultType = "application/octet-stream";
    private static final String     mapFile     = "mime.types";
    private static final String     indexTmpl   = "index.tpl";
    private static final DateFormat df          = new SimpleDateFormat("yyyy-HH-dd HH:mm:ss");

    private static final Map<String, String> mineMap = new HashMap<>();

    static {
        mineMap.put("css", "text/css");
        mineMap.put("scss", "text/plain");
        mineMap.put("html", "text/html");
        mineMap.put("js", "application/x-javascript");
        mineMap.put("git", "image/gif");
        mineMap.put("png", "image/png");
        mineMap.put("jpg", "image/jpeg");
        mineMap.put("jpeg", "image/jpeg");
        mineMap.put("clj", "text/plain");
        mineMap.put("conf", "text/plain");
        mineMap.put("xml", "text/xml");
    }

    public static String getExtension(File file) {
        String name = file.getName();
        int index = name.lastIndexOf('.');
        if (index != -1)
            return name.substring(index + 1).toLowerCase();
        else
            return "";
    }

    public static String getContentType(File file) {
        if (file.isDirectory()) {
            return "text/html";
        }
        String ext = getExtension(file);
        if (mineMap.get(ext) == null) {
            return defaultType;
        }
        return mineMap.get(ext);
    }

    public static Object listDir(final File folder) {
        record Dir(List<FileItem> fileItems, String dir) {
        }
        File[] files = folder.listFiles();
        final List<FileItem> fileItems = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                String href = file.isDirectory() ? file.getName() + "/" : file.getName();
                String mtime = df.format(new Date(file.lastModified()));
                fileItems.add(new FileItem(href, file.getName(),
                        String.valueOf(file.length()), mtime));
            }
        }
        Collections.sort(fileItems);
        return new Dir(fileItems, folder.getName());
    }

    public static byte[] file2ByteArray(File file, boolean zip) throws IOException {
        if (file.isDirectory()) {
            return directory2ByteArray(file, zip);
        }
        return normalFile2ByteArray(file, zip);
    }

    public static int subArrayFromEnd(byte[] data, byte[] toFind) {
        return indexOf(data, toFind, data.length - toFind.length);
    }

    public static int subArray(byte[] data, byte[] toFind, int start) {
        return indexOf(data, toFind, start);
    }

    public static void closeQuietly(Closeable os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException ignore) {
            }
        }
    }

    private static byte[] normalFile2ByteArray(File file, boolean zip) throws IOException {
        InputStream is = null;
        GZIPOutputStream gzip = null;
        byte[] buffer = new byte[8912];
        ByteArrayOutputStream baos = new ByteArrayOutputStream(8912);
        try {
            if (zip) {
                gzip = new GZIPOutputStream(baos);
            }
            is = new BufferedInputStream(new FileInputStream(file));
            int read;
            while ((read = is.read(buffer)) != -1) {
                if (zip) {
                    gzip.write(buffer, 0, read);
                } else {
                    baos.write(buffer, 0, read);
                }
            }
        } finally {
            closeQuietly(is);
            closeQuietly(gzip);
        }
        return baos.toByteArray();
    }

    private static byte[] directory2ByteArray(File dir, boolean zip) {
        // todo https://zhuanlan.zhihu.com/p/36572041
        // mustache 模板引擎
        return new byte[] {};
    }

    private static int indexOf(byte[] source, byte[] target, int start) {
        int index = source.length;
        outer:
        for (int i = start; i < source.length; ++i) {
            for (int j = 0; j < target.length; ++j) {
                if (source[i] == target[j]) {
                    ++i;
                    ++j;
                    if (j == target.length) {
                        index = i - target.length;
                        break outer;
                    }
                } else {
                    i = i - j;
                    break;
                }
            }
        }
        return index;
    }

    public record FileItem(
            String href, String name, String size, String mtime
    ) implements Comparable<FileItem> {
        public int compareTo(FileItem o) {
            return name.compareTo(o.name);
        }
    }

    private static final String template = """
            <!DOCTYPE HTML>
             <html>
               <head>
                 <title>Direcoty List</title>
                 <style type="text/css">
                   body {
                     width: 80%;
                     padding: 0;
                     margin: 0 10%;
                   }
                   td, th {
             	    padding: 2px 0;
                   }
                   table {
                     width: 100%;
                   }
                   table tr:nth-child(even) {
                      background: #F5FAFF;
                   }
                   .size, .mtime {
                      text-align: center;
                   }
                 </style>
               </head>
               <body>
                 <h1>{{dir}}/</h1>
                 <table>
                   <thead>
                     <tr>
                       <th>Name</th>
                       <th>Size</th>
                       <th>Last Modified</th>
                     </tr>
                   </thead>
                   <tbody>
                     {{#files}}
                     <tr>
                       <td><a href="{{href}}">{{name}}</a></td>
                       <td class='size'>{{size}}</td>
                       <td class='mtime'>{{mtime}}</td>
                     </tr>
                     {{/files}}
                   </tbody>
                 </table>
               </body>
             </html>""";
}
