package FetchList.Repo;


import FetchList.Model.FetchList1;
import com.mysql.cj.protocol.Resultset;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.lang.String;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class FetchListRepo implements FetchListRepoImpl {
    String url = "jdbc:mysql://localhost:3306/stud";
    String username = "root";
    String password = "";


    @Override
    public List<FetchList1> fetchList() {
        String query;
        query = "select * from student";

        List<FetchList1> fetchList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                FetchList1 f1 = new FetchList1();
                f1.setId((rs.getInt(1)));
                f1.setName(rs.getString(2));
                f1.setEmail(rs.getString(3));

                fetchList.add(f1);


            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return fetchList;

    }

    @Override
    public boolean deleteData(int id) {
        String query = "delete from student where id='" + id + "'";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
          int result=  st.executeUpdate(query);
          if (result==0){
              System.out.println("not deleted try again");
              return false;

          }

        }catch (Exception e){
            System.out.println(e);
        }
        return true;
    }

    @Override
    public void insertMen(FetchList1 fetchList1) {
        String query = "insert into student values('"+fetchList1.getId()
                +"','"+fetchList1.getName()
                +"','"+fetchList1.getEmail()+"')";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement st = connection.createStatement();
            st.executeUpdate(query);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    }
