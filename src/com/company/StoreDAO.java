package com.company;

import com.company.domain.MenuVO;
import com.company.domain.StoreVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StoreDAO {
    //음식점의 목록을 갖고오는 기능
    public List<StoreVO> getAll(){

        String sql="select * from tbl_store order by sname";
        List<StoreVO> list = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; //select를 날릴거라면 쓰는거임

        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.95:1521:XE",
                    "zz","12345678");
            System.out.println(con);//디버깅용
            stmt = con.prepareStatement(sql); //sql문을 미리 전달

            rs = stmt.executeQuery();

            while(rs.next()){
                StoreVO vo = new StoreVO();
                vo.setSno(rs.getInt("sno"));
                vo.setLat(rs.getDouble("lat"));
                vo.setLng(rs.getDouble("lng"));
                vo.setSname(rs.getString("sname"));
                vo.setGubun(rs.getString("gubun"));
                vo.setImg(rs.getString("img"));

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
