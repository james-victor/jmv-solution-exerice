import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * 此类中封装一些常用的文件操作。
 * 所有方法都是静态方法，不需要生成此类的实例，
 * 为避免生成此类的实例，构造方法被申明为private类型的。
 */
public class FileUtil {

    private static final String driver = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://192.168.4.83:5432/itms?currentSchema=public";
    private static final String username = "itms";
    private static final String password = "glzt#itms123";
    private static Connection connection = null;
    private static Statement statement = null;


    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束

            Class.forName(driver);
            //创建连接对象
            connection = DriverManager.getConnection(url, username, password);
            int count = 1;

            statement = connection.createStatement();
            String sb = "";
            while ((tempString = reader.readLine()) != null) {
                System.out.println("line " + line + ": " + tempString);
                if (line >= 6) {
                    if (tempString.startsWith("insert") || tempString.startsWith("values")) {
                        sb += tempString;
                    }
                    if (sb.startsWith("insert") && sb.endsWith(");")) {
                        sb = sb.replaceAll("ITS_POLICE_BAYONET_", "its_police_bayonet_");
                        System.out.println("count" + count + ": " + sb);
                        insert(sb);
                        sb = "";
                        count++;
                    }
                }
                line++;
            }
            reader.close();
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    public static void main(String[] args) {
//        FileUtil.readFileByLines("C:\\p\\polstat_202008.sql");
//        FileUtil.readFileByLines("D:\\项目文档\\公司\\智慧交通管理系统\\数据\\龙泉交通数据\\polstat\\polstat_202006.sql");

        Date date  = new Date(1547009666541L);
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(sdf.format(date));
    }

    public static void insert(String sql) throws IOException {
        try {
            //对信息语句进行预处理
//            preparedStatement = connection.prepareStatement(sql);
            // 查询
//            rs = preparedStatement.executeQuery();
            // 增加 删除 修改
            statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}