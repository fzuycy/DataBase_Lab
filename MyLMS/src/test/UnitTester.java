package test;

import org.junit.Test;
import utils.DBUtil;
import view.RootXiugaiMima;

import java.sql.Connection;


public class UnitTester {
    @Test
    public void test1(){
        Connection conn=null;
        try {
            conn = DBUtil.getConn();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
    @Test
    public void test2(){
//        while(true){
//            new RootXiugaiMima().setVisible(true);
//        }

    }

}
