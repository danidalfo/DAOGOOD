package DAOGOOD;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.apache.log4j.Logger;


public abstract class DAO {

    protected int id;

    final static Logger logger = Logger.getLogger(DAO.class);

    public void setId(int id) {
        this.id=id;
    }

    public int getId() {
        return this.id;
    }

    private Connection getConnection() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/karthicraj",
                    "mysql","mysql");
            return con;
        }
        catch (Exception e) {
            e.printStackTrace();


        }

        return null;

    }

    private String  queryInsert()
    {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(this.getClass().getSimpleName());
        sb.append(" (");
        Field[] fields = this.getClass().getDeclaredFields();
        for (int i=0 , manel = 0 ; i < fields.length ; i++ , manel++)
        {
            sb.append(fields[i].getName());
            if (manel != fields.length -1)
            {
                sb.append(",");
            }
        }
        sb.append(") ");
        sb.append("VALUES");
        sb.append("(");
        for (int i=0 , manel = 0 ; i < fields.length ; i++ , manel++)
        {
            sb.append("?");
            if (manel != fields.length -1)
            {
                sb.append(",");
            }
            sb.append(")");
        }



        logger.info(sb.toString());
        System.out.println(sb.toString());

        return sb.toString();
    }

    private String querySelect(){

        StringBuffer sb = new StringBuffer("SELECT ");
        sb.append("* FROM");
        sb.append(this.getClass().getSimpleName());

        return sb.toString();
    }

    public void insert() {
        try {

            String theQuery = this.queryInsert();

            Connection con = this.getConnection();

            PreparedStatement pstm = con.prepareStatement(theQuery);
            pstm.setString(1, "Mick Jagggger");

            //  pstm.exe
        }
        catch (Exception e)
        {
            logger.error("Hi ha una exception!");
            logger.error(e.getMessage());
        }
    }

    public void select(){
        try {
            String theQuery = this.querySelect();

            Connection con=null;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
