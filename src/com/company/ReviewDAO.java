package com.company;

import com.company.domain.ReviewVO;
import com.company.domain.ScoreVO;
import com.company.domain.StoreVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ReviewDAO {

    public List<ReviewVO> getReviews(int sno){
        List<ReviewVO> list = new ArrayList<>();
        String sql="select * from tbl_review \n" +
                "where mno in (select mno from tbl_menu where sno=?)\n" +
                "order by rno desc";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.95:1521:XE",
                    "zz","12345678");
            System.out.println(con);//디버깅용
            stmt = con.prepareStatement(sql); //sql문을 미리 전달
            stmt.setInt(1,sno);
            rs = stmt.executeQuery();


            while(rs.next()){
                ReviewVO vo = new ReviewVO();
                vo.setRno(rs.getInt("rno"));
                vo.setMno(rs.getInt("mno"));
                vo.setMid(rs.getString("mid"));
                vo.setCmt(rs.getString("cmt"));
                vo.setReviewDate(rs.getDate("reviewDate"));
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

    public List<ScoreVO> getScores(int sno){
        List<ScoreVO> list = new ArrayList<>();
        String sql ="select s.score, nvl(cnt,0) cnt, \n" +
                "     ROUND(nvl(cnt,0) / ( sum(nvl(cnt,0)) over() ) * 100) pnt\n" +
                "from \n" +
                "  (select round(score) score ,count(rno) cnt\n" +
                "    from\n" +
                "      (select mno from tbl_menu where sno = ?) menu,\n" +
                "      tbl_review review\n" +
                "    where menu.mno = review.mno\n" +
                "    group by round(score) ) review, tbl_score s\n" +
                "where s.score = review.score(+)    \n" +
                "order by s.score desc";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.95:1521:XE", "zz", "12345678");
            System.out.println(con);
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, sno);
            rs = stmt.executeQuery();

            while(rs.next()){
                ScoreVO vo = new ScoreVO();
                vo.setScore(rs.getInt("score"));
                vo.setCnt(rs.getInt("cnt"));
                vo.setPnt(rs.getInt("pnt"));
                list.add(vo);
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            if(rs != null) {      try { rs.close(); }catch(Exception e){}            }
            if(stmt != null) {      try { stmt.close(); }catch(Exception e){}            }
            if(con != null) {       try { con.close(); }catch(Exception e){}            }
        }//end finally


        return list;
    }

    public void add(ReviewVO vo){


        Connection con = null;
        PreparedStatement stmt = null;
        String sql =
                "insert into tbl_review(rno,mid,mno,score,cmt) values(seq_review.nextval,?,?,?,?)";//내가 값을 넣을 부분에 ?로 넣어두기
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.95:1521:XE",
                    "zz","12345678");
            System.out.println(con);
            stmt = con.prepareStatement(sql); //sql문을 미리 전달
            System.out.println(sql);
            //mid mno score
            stmt.setString(1,vo.getMid()); //1번째 ?에
            stmt.setInt(2,vo.getMno()); //2번째 ?에
            stmt.setDouble(3,vo.getScore()); //3번째 ?에
            stmt.setString(4,vo.getCmt()); //4번째 ?에
            int count  = stmt.executeUpdate();

            System.out.println(count);


        }catch (Exception e){
            System.out.println(e.getMessage());

        }finally {
            if(stmt !=null){
                try{stmt.close();}catch (Exception e){}

            }// end if
        }// end finally
    }//end method
}
