package com.company;

public class Main {

    public static void main(String[] args) {

        //투표할 때 사용
//        VoteDAO dao = new VoteDAO();
//        dao.addVote("user");

        //db에서 안쓰고 여기다 쓰면 db로감
//        ReviewVO vo = new ReviewVO();
//        vo.setMid("zz");
//        vo.setMno(21);
//        vo.setScore(4.7);
//        vo.setCmt("구웃~!");
//        ReviewDAO dao = new ReviewDAO();
//        dao.add(vo);

        //4번인 애가 해당하는 음식점들의 음식이 나옴
//        MenuDAO menuDAO = new MenuDAO();
//        System.out.println(menuDAO.getMenus(1));

        //StoreDAO test
      //  new StoreDAO().getAll().stream().forEach(vo -> System.out.println(vo));

        //6번 가게의 평점이 나옴
        new ReviewDAO().getScores(6).stream().forEach(s-> System.out.println(s));

       // new ReviewDAO().getReviews(6).stream().forEach(r-> System.out.println(r));




	// write your code here
    }
}
