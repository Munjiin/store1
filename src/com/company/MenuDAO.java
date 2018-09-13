package com.company;

import com.company.domain.MenuVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {

    //가게번호를 주면
    public List<MenuVO> getMenus (int sno){

        String sql="select *from tbl_menu where sno =? order by mno";
        List<MenuVO> list = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.95:1521:XE",
                    "zz","12345678");
            System.out.println(con);
            stmt = con.prepareStatement(sql); //sql문을 미리 전달
           // System.out.println(sql);
            //mid mno score
            stmt.setInt(1,sno);

            rs = stmt.executeQuery();
            while(rs.next()){
                MenuVO vo = new MenuVO();
                vo.setMno(rs.getInt("mno"));
                vo.setSno(rs.getInt("sno"));
                vo.setMname(rs.getString("mname"));
                vo.setPrice(rs.getInt("price"));
                list.add(vo);

            }

        }catch (Exception e){
            System.out.println(e.getMessage());

        }finally {
            if (rs != null) { try {rs.close(); } catch (Exception e) { }}
            if (stmt != null) { try {stmt.close(); } catch (Exception e) { }}
            if (con != null) { try {con.close(); } catch (Exception e) { } }// end if
        }//end finally

        return list;
    }
}

